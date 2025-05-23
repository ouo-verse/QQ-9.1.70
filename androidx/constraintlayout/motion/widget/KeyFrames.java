package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.util.Log;
import android.util.Xml;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: P */
/* loaded from: classes.dex */
public class KeyFrames {
    private static final String TAG = "KeyFrames";
    public static final int UNSET = -1;
    static HashMap<String, Constructor<? extends Key>> sKeyMakers;
    private HashMap<Integer, ArrayList<Key>> mFramesMap = new HashMap<>();

    static {
        HashMap<String, Constructor<? extends Key>> hashMap = new HashMap<>();
        sKeyMakers = hashMap;
        try {
            hashMap.put("KeyAttribute", KeyAttributes.class.getConstructor(new Class[0]));
            sKeyMakers.put("KeyPosition", KeyPosition.class.getConstructor(new Class[0]));
            sKeyMakers.put("KeyCycle", KeyCycle.class.getConstructor(new Class[0]));
            sKeyMakers.put("KeyTimeCycle", KeyTimeCycle.class.getConstructor(new Class[0]));
            sKeyMakers.put("KeyTrigger", KeyTrigger.class.getConstructor(new Class[0]));
        } catch (NoSuchMethodException e16) {
            Log.e(TAG, "unable to load", e16);
        }
    }

    public KeyFrames(Context context, XmlPullParser xmlPullParser) {
        Exception e16;
        Key key;
        HashMap<String, ConstraintAttribute> hashMap;
        try {
            int eventType = xmlPullParser.getEventType();
            Key key2 = null;
            while (eventType != 1) {
                if (eventType != 2) {
                    if (eventType == 3 && "KeyFrameSet".equals(xmlPullParser.getName())) {
                        return;
                    }
                } else {
                    String name = xmlPullParser.getName();
                    if (sKeyMakers.containsKey(name)) {
                        try {
                            key = sKeyMakers.get(name).newInstance(new Object[0]);
                        } catch (Exception e17) {
                            Key key3 = key2;
                            e16 = e17;
                            key = key3;
                        }
                        try {
                            key.load(context, Xml.asAttributeSet(xmlPullParser));
                            addKey(key);
                        } catch (Exception e18) {
                            e16 = e18;
                            Log.e(TAG, "unable to create ", e16);
                            key2 = key;
                            eventType = xmlPullParser.next();
                        }
                        key2 = key;
                    } else if (name.equalsIgnoreCase("CustomAttribute") && key2 != null && (hashMap = key2.mCustomConstraints) != null) {
                        ConstraintAttribute.parse(context, xmlPullParser, hashMap);
                    }
                }
                eventType = xmlPullParser.next();
            }
        } catch (IOException e19) {
            e19.printStackTrace();
        } catch (XmlPullParserException e26) {
            e26.printStackTrace();
        }
    }

    private void addKey(Key key) {
        if (!this.mFramesMap.containsKey(Integer.valueOf(key.mTargetId))) {
            this.mFramesMap.put(Integer.valueOf(key.mTargetId), new ArrayList<>());
        }
        this.mFramesMap.get(Integer.valueOf(key.mTargetId)).add(key);
    }

    static String name(int i3, Context context) {
        return context.getResources().getResourceEntryName(i3);
    }

    public void addFrames(MotionController motionController) {
        ArrayList<Key> arrayList = this.mFramesMap.get(Integer.valueOf(motionController.mId));
        if (arrayList != null) {
            motionController.addKeys(arrayList);
        }
        ArrayList<Key> arrayList2 = this.mFramesMap.get(-1);
        if (arrayList2 != null) {
            Iterator<Key> it = arrayList2.iterator();
            while (it.hasNext()) {
                Key next = it.next();
                if (next.matches(((ConstraintLayout.LayoutParams) motionController.mView.getLayoutParams()).constraintTag)) {
                    motionController.addKey(next);
                }
            }
        }
    }

    public ArrayList<Key> getKeyFramesForView(int i3) {
        return this.mFramesMap.get(Integer.valueOf(i3));
    }

    public Set<Integer> getKeys() {
        return this.mFramesMap.keySet();
    }
}
