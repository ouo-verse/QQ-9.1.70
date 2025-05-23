package com.tencent.mobileqq.troop.activity;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.Editable;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.data.TroopBarAbsDataEntity;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonPanel;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.troop.data.AudioInfo;
import com.tencent.mobileqq.troop.utils.s;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.al;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes19.dex */
public class TroopBarPublishUtils {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static String f293662a;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f293663b;

    /* renamed from: c, reason: collision with root package name */
    public static Editable.Factory f293664c;

    /* loaded from: classes19.dex */
    class a extends Editable.Factory {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.text.Editable.Factory
        public Editable newEditable(CharSequence charSequence) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Editable) iPatchRedirector.redirect((short) 2, (Object) this, (Object) charSequence);
            }
            if (charSequence instanceof QQTextBuilder) {
                return (Editable) charSequence;
            }
            return new QQTextBuilder(charSequence, 3, 20);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(76158);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f293662a = null;
        f293663b = false;
        f293664c = new a();
    }

    @TargetApi(11)
    public static SystemAndEmojiEmoticonPanel a(Context context, ViewGroup viewGroup, EditText editText, EmoticonCallback emoticonCallback) {
        editText.setEditableFactory(f293664c);
        com.tencent.devicelib.a.a(context, editText);
        SystemAndEmojiEmoticonPanel systemAndEmojiEmoticonPanel = new SystemAndEmojiEmoticonPanel(context, emoticonCallback);
        systemAndEmojiEmoticonPanel.setBackgroundResource(R.drawable.aio_face_bg);
        ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, (int) al.a(context, 196.0f));
        int a16 = (int) al.a(context, 20.0f);
        systemAndEmojiEmoticonPanel.setPadding(0, a16, 0, a16);
        viewGroup.addView(systemAndEmojiEmoticonPanel, layoutParams);
        systemAndEmojiEmoticonPanel.setVisibility(8);
        return systemAndEmojiEmoticonPanel;
    }

    public static int b(String str, String str2) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return 0;
        }
        if (!TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return 1;
        }
        if (TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            return -1;
        }
        String[] split = str.split("\\.");
        String[] split2 = str2.split("\\.");
        int i3 = 0;
        while (i3 < split.length && i3 < split2.length) {
            try {
                int parseInt = Integer.parseInt(split[i3]);
                int parseInt2 = Integer.parseInt(split2[i3]);
                if (parseInt < parseInt2) {
                    return -1;
                }
                if (parseInt > parseInt2) {
                    return 1;
                }
                i3++;
            } catch (NumberFormatException e16) {
                e16.printStackTrace();
                return str.compareTo(str2);
            }
        }
        if (split.length > i3) {
            return 1;
        }
        if (split2.length <= i3) {
            return 0;
        }
        return -1;
    }

    public static String c(String str, ArrayList<String> arrayList, AudioInfo audioInfo) {
        return d(str, arrayList, audioInfo, null);
    }

    public static String d(String str, ArrayList<String> arrayList, AudioInfo audioInfo, com.tencent.mobileqq.tribe.data.a aVar) {
        JSONObject jSONObject = new JSONObject();
        if (str == null) {
            str = "";
        }
        try {
            jSONObject.put("content", str);
        } catch (JSONException unused) {
        }
        if (arrayList != null && !arrayList.isEmpty()) {
            ArrayList arrayList2 = new ArrayList(arrayList);
            JSONArray jSONArray = new JSONArray();
            int i3 = 0;
            for (int i16 = 0; i16 < arrayList2.size(); i16++) {
                String str2 = (String) arrayList2.get(i16);
                Pic_list pic_list = s.f302206g.get(str2);
                if (pic_list != null) {
                    jSONArray.mo162put(pic_list.getJsonObject());
                    if (BaseImageUtil.isGifFile(str2)) {
                        i3++;
                    }
                }
            }
            try {
                jSONObject.put("pic_list", jSONArray);
                jSONObject.put("gif_num", i3);
            } catch (JSONException unused2) {
            }
        }
        if (audioInfo != null) {
            JSONArray jSONArray2 = new JSONArray();
            try {
                jSONArray2.mo162put(new JSONObject(audioInfo.getJsonText()));
                jSONObject.put("audio_list", jSONArray2);
            } catch (JSONException e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("TroopBarPublishUtils", 2, e16.getMessage());
                }
            }
        }
        return jSONObject.toString();
    }

    public static boolean e() {
        return true;
    }

    public static void f(Activity activity, int i3, int i16) {
        Intent intent = new Intent(activity, (Class<?>) QQBrowserActivity.class);
        intent.putExtra("url", "https://buluo.qq.com/mobile/video_theme.html?_wv=1031&video_theme_id=" + i16);
        activity.startActivityForResult(intent, i3);
    }

    /* loaded from: classes19.dex */
    public static class Pic_list extends TroopBarAbsDataEntity {
        static IPatchRedirector $redirector_ = null;
        protected static final String JSON_KEY_H = "h";
        protected static final String JSON_KEY_TYPE = "type";
        protected static final String JSON_KEY_TYPE_INFO = "type_info";
        protected static final String JSON_KEY_URL = "url";
        protected static final String JSON_KEY_W = "w";
        protected static final long serialVersionUID = 10008;
        public boolean canReuse;

        /* renamed from: h, reason: collision with root package name */
        public int f293665h;
        public String type;
        public String url;

        /* renamed from: w, reason: collision with root package name */
        public int f293666w;

        public Pic_list() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                this.canReuse = true;
            } else {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public JSONObject getJsonObject() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (JSONObject) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("url", this.url);
                jSONObject.put("w", this.f293666w);
                jSONObject.put("h", this.f293665h);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("type", this.type);
                jSONObject.put(JSON_KEY_TYPE_INFO, jSONObject2);
                return jSONObject;
            } catch (JSONException unused) {
                return null;
            }
        }

        @Override // java.io.Externalizable
        public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) objectInput);
                return;
            }
            this.url = objectInput.readUTF();
            this.f293666w = objectInput.readInt();
            this.f293665h = objectInput.readInt();
            this.type = objectInput.readUTF();
        }

        @Override // java.io.Externalizable
        public void writeExternal(ObjectOutput objectOutput) throws IOException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) objectOutput);
                return;
            }
            objectOutput.writeUTF(this.url);
            objectOutput.writeInt(this.f293666w);
            objectOutput.writeInt(this.f293665h);
            objectOutput.writeUTF(this.type);
        }

        public Pic_list(JSONObject jSONObject) {
            super(jSONObject);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) jSONObject);
                return;
            }
            this.canReuse = true;
            this.url = jSONObject.optString("url", "");
            this.f293666w = jSONObject.optInt("w", -1);
            this.f293665h = jSONObject.optInt("h", -1);
            JSONObject optJSONObject = jSONObject.optJSONObject(JSON_KEY_TYPE_INFO);
            if (optJSONObject != null) {
                this.type = optJSONObject.optString("type", "");
            }
        }
    }

    public static void g(boolean z16) {
    }
}
