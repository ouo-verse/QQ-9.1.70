package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import com.qzone.homepage.business.model.FunnySpaceModel;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.aekit.plugin.core.AIInput;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.AnimationTools;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes20.dex */
public class AnimationView extends RoundImageView {
    protected AnimationInfo D;
    protected Player E;
    protected MyAnimationListener F;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface MyAnimationListener {
        void onAnimationEnd(AnimationView animationView);

        void onAnimationRepeat(AnimationView animationView);

        void onAnimationStart(AnimationView animationView);
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class Player implements Handler.Callback {
        public static final int MSG_PLAY = 1;
        protected WeakReference<AnimationView> D;

        /* renamed from: d, reason: collision with root package name */
        final int f315399d = 0;

        /* renamed from: e, reason: collision with root package name */
        final int f315400e = 1;

        /* renamed from: f, reason: collision with root package name */
        final int f315401f = 2;

        /* renamed from: h, reason: collision with root package name */
        int f315402h = 0;

        /* renamed from: i, reason: collision with root package name */
        int f315403i = 0;

        /* renamed from: m, reason: collision with root package name */
        int f315404m = 0;
        boolean C = false;
        protected Handler E = new Handler(this);

        public Player(AnimationView animationView) {
            this.D = new WeakReference<>(animationView);
        }

        protected void a() {
            AnimationView animationView = this.D.get();
            if (animationView != null && this.f315402h != 2) {
                Drawable b16 = b(animationView);
                if (b16 != null) {
                    animationView.setImageDrawable(b16);
                }
                MyAnimationListener myAnimationListener = animationView.F;
                if (myAnimationListener != null) {
                    int i3 = this.f315403i;
                    if (i3 == 1 && this.f315404m > 0) {
                        myAnimationListener.onAnimationRepeat(animationView);
                    } else if (i3 == 1 && this.f315404m == 0) {
                        if (!this.C) {
                            this.C = true;
                            myAnimationListener.onAnimationStart(animationView);
                        }
                    } else if (this.f315402h == 2) {
                        myAnimationListener.onAnimationEnd(animationView);
                    }
                }
                this.E.sendMessageDelayed(this.E.obtainMessage(1), getNextFrameDelay(animationView));
            }
        }

        protected Drawable b(AnimationView animationView) {
            AnimationInfo animationInfo;
            boolean z16;
            int i3;
            if (animationView != null && (animationInfo = animationView.D) != null) {
                if (this.f315402h == 2) {
                    return null;
                }
                if (animationInfo.mOneCycleFrames.size() <= 0) {
                    this.f315402h = 2;
                    return null;
                }
                int i16 = this.f315403i;
                if (i16 >= 0 && i16 <= animationInfo.mOneCycleFrames.size()) {
                    int i17 = this.f315403i;
                    int i18 = i17 + 1;
                    int i19 = animationInfo.mInfiniteFromInOnCycle;
                    if (i19 > 0 && (i3 = animationInfo.mInfiniteToInOnCycle) > 0 && i3 > i19) {
                        if (i17 == i3) {
                            i18 = i19;
                        }
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (i18 > animationInfo.mOneCycleFrames.size()) {
                        int i26 = animationInfo.mCycle;
                        if (i26 < 0) {
                            this.f315402h = 2;
                        } else if (i26 != 0 && this.f315404m >= i26) {
                            this.f315402h = 2;
                        }
                        if (this.f315402h == 2) {
                            return null;
                        }
                        i18 = 1;
                    } else if (i18 == animationInfo.mOneCycleFrames.size() && !z16) {
                        this.f315404m++;
                    }
                    this.f315403i = i18;
                    return animationInfo.mFrames.get(animationInfo.mOneCycleFrames.get(i18 - 1).intValue());
                }
                this.f315402h = 2;
                return null;
            }
            this.f315402h = 2;
            return null;
        }

        public int getNextFrameDelay(AnimationView animationView) {
            AnimationInfo animationInfo;
            if (animationView != null && (animationInfo = animationView.D) != null) {
                if (this.f315403i >= animationInfo.mOneCycleFrames.size()) {
                    return animationView.D.mDelay;
                }
                return animationView.D.mInterval;
            }
            return 100;
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 1) {
                a();
                return false;
            }
            return false;
        }

        public void pause() {
            stop();
        }

        public void play() {
            reset();
            this.f315402h = 1;
            a();
        }

        public void reset() {
            this.f315403i = 0;
            this.f315404m = 0;
            this.f315402h = 0;
            this.C = false;
        }

        public void resume() {
            AnimationView animationView = this.D.get();
            if (this.f315402h != 1 && animationView != null) {
                this.f315402h = 1;
                a();
                MyAnimationListener myAnimationListener = animationView.F;
                if (myAnimationListener != null) {
                    myAnimationListener.onAnimationStart(animationView);
                }
            }
        }

        public void stop() {
            this.f315402h = 2;
            this.E.removeCallbacksAndMessages(null);
        }
    }

    public AnimationView(Context context) {
        super(context);
    }

    public AnimationInfo getAnimationFromInfo() {
        return this.D;
    }

    public Player getPlayer() {
        return this.E;
    }

    public void pause() {
        Player player = this.E;
        if (player == null) {
            return;
        }
        player.pause();
    }

    public void play() {
        Player player = this.E;
        if (player == null) {
            return;
        }
        player.play();
    }

    public void resume() {
        Player player = this.E;
        if (player == null) {
            return;
        }
        player.resume();
    }

    public void setAnimationFromBitmaps(ArrayList<Bitmap> arrayList, int i3, int i16) {
        if (arrayList != null && arrayList.size() > 0) {
            ArrayList<Drawable> arrayList2 = new ArrayList<>();
            for (int i17 = 0; i17 < arrayList.size(); i17++) {
                arrayList2.add(new BitmapDrawable(getResources(), arrayList.get(i17)));
            }
            setAnimationFromDrawabs(arrayList2, i3, i16);
        }
    }

    public void setAnimationFromDrawabs(Drawable[] drawableArr, int i3, int i16) {
        if (drawableArr == null || drawableArr.length <= 0 || i3 <= 0) {
            return;
        }
        ArrayList<Drawable> arrayList = new ArrayList<>();
        for (Drawable drawable : drawableArr) {
            arrayList.add(drawable);
        }
        setAnimationFromDrawabs(arrayList, i3, i16);
    }

    public void setAnimationFromInfo(AnimationInfo animationInfo) {
        this.D = animationInfo;
        if (this.E == null) {
            this.E = new Player(this);
        }
    }

    public void setAnimationListener(MyAnimationListener myAnimationListener) {
        this.F = myAnimationListener;
    }

    public void setPlayer(Player player) {
        this.E = player;
    }

    public void stop() {
        Player player = this.E;
        if (player == null) {
            return;
        }
        player.stop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class PlayItem {
        public int mCycle;
        public int mFrame;
        public int mFrom;
        public int mTo;

        public PlayItem(int i3) {
            this.mFrame = i3;
        }

        protected static PlayItem a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            int optInt = jSONObject.optInt(AIInput.KEY_FRAME);
            if (optInt > 0) {
                return new PlayItem(optInt);
            }
            int optInt2 = jSONObject.optInt("from");
            int optInt3 = jSONObject.optInt("to");
            int i3 = 1;
            int optInt4 = jSONObject.optInt(FunnySpaceModel.META_KEY_CYCLE, 1);
            if (optInt3 <= 0 || optInt2 <= 0 || optInt3 <= optInt2) {
                return null;
            }
            if (optInt4 >= 0) {
                i3 = optInt4;
            }
            return new PlayItem(optInt2, optInt3, i3);
        }

        public ArrayList<Integer> getFrames() {
            int i3;
            ArrayList<Integer> arrayList = new ArrayList<>();
            int i16 = this.mFrame;
            if (i16 > 0) {
                arrayList.add(Integer.valueOf(i16));
            } else {
                int i17 = this.mTo;
                if (i17 > 0 && (i3 = this.mFrom) > 0 && i17 > i3) {
                    while (i3 < this.mTo + 1) {
                        arrayList.add(Integer.valueOf(i3));
                        i3++;
                    }
                }
            }
            return arrayList;
        }

        public PlayItem(int i3, int i16, int i17) {
            this.mFrom = i3;
            this.mTo = i16;
            this.mCycle = i17;
        }
    }

    public AnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AnimationView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }

    public void setAnimationFromDrawabs(ArrayList<Drawable> arrayList, int i3, int i16) {
        if (arrayList == null || arrayList.size() <= 0 || i3 <= 0) {
            return;
        }
        this.D = AnimationInfo.loadFromFrames(arrayList, i3, i16);
        if (this.E == null) {
            this.E = new Player(this);
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class AnimationInfo {
        public static final int DEFAULT_FRAME_RATE = 100;
        public static final int ZIP_STATE_EMPTY_ZIP = 4;
        public static final int ZIP_STATE_NOT_EXIST = 2;
        public static final int ZIP_STATE_NO_IMAGE_FILE = 5;
        public static final int ZIP_STATE_UNZIP_FAILURE = 3;
        public static final int ZIP_STATE_VALID = 1;
        public int mCycle;
        public int mDelay;
        public SparseArray<Drawable> mFrames;
        public int mInfiniteFromInOnCycle;
        public int mInfiniteToInOnCycle;
        public int mInterval;
        public ArrayList<Integer> mOneCycleFrames;
        public ArrayList<PlayItem> mPlay;

        public AnimationInfo() {
            this.mPlay = new ArrayList<>();
            this.mFrames = new SparseArray<>();
            this.mOneCycleFrames = new ArrayList<>();
            this.mCycle = 0;
            this.mInterval = 100;
            this.mDelay = 100;
            this.mInfiniteFromInOnCycle = -1;
            this.mInfiniteToInOnCycle = -1;
        }

        protected static int a(String str) {
            if (!new File(str).exists()) {
                return 2;
            }
            String str2 = str + "Folder";
            File file = new File(str2);
            if (!file.exists() && !AnimationTools.unzipAtomically(str, str2)) {
                return 3;
            }
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length > 0) {
                for (int i3 = 0; i3 < listFiles.length; i3++) {
                    File file2 = listFiles[i3];
                    if (file2 != null && file2.isFile() && FileUtils.isPicFile(listFiles[i3].getAbsolutePath())) {
                        return 1;
                    }
                }
                return 5;
            }
            FileUtils.delete(str2, false);
            return 4;
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0024 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:13:0x0025  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        protected static AnimationInfo d(File file) {
            String str;
            byte[] bArr;
            if (file == null || !file.exists()) {
                return null;
            }
            try {
                bArr = FileUtils.getByte(file);
            } catch (Exception e16) {
                e16.printStackTrace();
            }
            if (bArr != null) {
                str = new String(bArr, "UTF-8");
                if (!TextUtils.isEmpty(str)) {
                    return null;
                }
                return e(str);
            }
            str = null;
            if (!TextUtils.isEmpty(str)) {
            }
        }

        protected static AnimationInfo e(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt(FunnySpaceModel.META_KEY_CYCLE, 0);
                int optInt2 = jSONObject.optInt(WidgetCacheConstellationData.INTERVAL, 100);
                int optInt3 = jSONObject.optInt("delay", 100);
                ArrayList<PlayItem> arrayList = new ArrayList<>();
                JSONArray optJSONArray = jSONObject.optJSONArray("play");
                if (optJSONArray != null) {
                    for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                        PlayItem a16 = PlayItem.a(optJSONArray.getJSONObject(i3));
                        if (a16 != null) {
                            arrayList.add(a16);
                        }
                    }
                }
                if (arrayList.size() > 0) {
                    AnimationInfo animationInfo = new AnimationInfo(optInt, optInt2, optInt3);
                    animationInfo.mPlay = arrayList;
                    animationInfo.b();
                    return animationInfo;
                }
            } catch (JSONException e16) {
                e16.printStackTrace();
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
            return null;
        }

        public static AnimationInfo loadFromFolder(String str) {
            AnimationInfo animationInfo;
            ArrayList<Integer> arrayList;
            BitmapDrawable bitmapDrawable;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            File file = new File(str, "play.cfg");
            if (file.exists()) {
                animationInfo = d(file);
            } else {
                animationInfo = null;
            }
            if (animationInfo != null) {
                arrayList = animationInfo.c();
            } else {
                arrayList = null;
            }
            int i3 = 0;
            if (animationInfo != null && arrayList != null && arrayList.size() > 0) {
                File[] listFiles = new File(str).listFiles();
                if (listFiles != null && listFiles.length > 0) {
                    AnimationTools.sortByFileNameNum(listFiles);
                    ArrayList arrayList2 = new ArrayList();
                    for (int i16 = 0; i16 < listFiles.length; i16++) {
                        File file2 = listFiles[i16];
                        if (file2 != null && file2.isFile() && FileUtils.isPicFile(listFiles[i16].getAbsolutePath())) {
                            arrayList2.add(listFiles[i16]);
                        }
                    }
                    SparseArray<Drawable> sparseArray = new SparseArray<>();
                    int i17 = 0;
                    boolean z16 = false;
                    while (i17 < arrayList2.size()) {
                        int i18 = i17 + 1;
                        if (arrayList.contains(Integer.valueOf(i18))) {
                            try {
                                bitmapDrawable = new BitmapDrawable(((File) arrayList2.get(i17)).getAbsolutePath());
                            } catch (OutOfMemoryError e16) {
                                if (QLog.isColorLevel()) {
                                    QLog.e("AnimationView", 2, "decode fail - OutOfMemoryError" + e16);
                                }
                                z16 = true;
                                bitmapDrawable = null;
                            }
                            if (!z16 && bitmapDrawable != null && bitmapDrawable.getBitmap() != null) {
                                sparseArray.append(i18, bitmapDrawable);
                            } else {
                                if (QLog.isColorLevel()) {
                                    QLog.e("AnimationView", 2, "decode fail till" + ((File) arrayList2.get(i17)).getAbsolutePath());
                                }
                                while (i3 < sparseArray.size()) {
                                    AnimationTools.destroyDrawable(sparseArray.valueAt(i3));
                                    i3++;
                                }
                                return null;
                            }
                        }
                        i17 = i18;
                    }
                    if (arrayList.size() != sparseArray.size()) {
                        while (i3 < sparseArray.size()) {
                            AnimationTools.destroyDrawable(sparseArray.valueAt(i3));
                            i3++;
                        }
                        return null;
                    }
                    animationInfo.mFrames = sparseArray;
                    return animationInfo;
                }
                if (QLog.isColorLevel()) {
                    QLog.e("AnimationView", 2, "nothing in unzip folder");
                }
                return null;
            }
            Drawable[] decodeDrawablesFromPath = AnimationTools.decodeDrawablesFromPath(str);
            if (decodeDrawablesFromPath == null || decodeDrawablesFromPath.length <= 0) {
                return null;
            }
            ArrayList arrayList3 = new ArrayList();
            while (i3 < decodeDrawablesFromPath.length) {
                arrayList3.add(decodeDrawablesFromPath[i3]);
                i3++;
            }
            return loadFromFrames(arrayList3, 100, 100);
        }

        public static AnimationInfo loadFromFrames(ArrayList<Drawable> arrayList, int i3, int i16) {
            if (arrayList != null && arrayList.size() > 0) {
                AnimationInfo animationInfo = new AnimationInfo(i16, i3, i3);
                int i17 = 0;
                while (i17 < arrayList.size()) {
                    int i18 = i17 + 1;
                    animationInfo.mPlay.add(new PlayItem(i18));
                    animationInfo.mFrames.append(i18, arrayList.get(i17));
                    i17 = i18;
                }
                animationInfo.b();
                return animationInfo;
            }
            return null;
        }

        public static AnimationInfo loadFromZip(String str) {
            if (TextUtils.isEmpty(str) || a(str) != 1) {
                return null;
            }
            return loadFromFolder(str + "Folder");
        }

        protected void b() {
            int i3;
            this.mInfiniteFromInOnCycle = -1;
            this.mInfiniteToInOnCycle = -1;
            this.mOneCycleFrames.clear();
            for (int i16 = 0; i16 < this.mPlay.size(); i16++) {
                PlayItem playItem = this.mPlay.get(i16);
                if (playItem != null) {
                    int i17 = playItem.mFrame;
                    if (i17 > 0) {
                        this.mOneCycleFrames.add(Integer.valueOf(i17));
                    } else {
                        int i18 = playItem.mFrom;
                        if (i18 > 0 && (i3 = playItem.mTo) > 0 && i3 > i18) {
                            int i19 = playItem.mCycle;
                            if (i19 <= 0) {
                                i19 = 1;
                            }
                            for (int i26 = 0; i26 < i19; i26++) {
                                for (int i27 = playItem.mFrom; i27 < playItem.mTo + 1; i27++) {
                                    this.mOneCycleFrames.add(Integer.valueOf(i27));
                                }
                            }
                            if (playItem.mCycle == 0) {
                                this.mInfiniteFromInOnCycle = playItem.mFrom;
                                this.mInfiniteToInOnCycle = playItem.mTo;
                                return;
                            }
                        }
                    }
                }
            }
        }

        protected ArrayList<Integer> c() {
            ArrayList<Integer> arrayList = new ArrayList<>();
            ArrayList<PlayItem> arrayList2 = this.mPlay;
            if (arrayList2 != null && arrayList2.size() > 0) {
                for (int i3 = 0; i3 < this.mPlay.size(); i3++) {
                    PlayItem playItem = this.mPlay.get(i3);
                    if (playItem != null) {
                        ArrayList<Integer> frames = playItem.getFrames();
                        for (int i16 = 0; i16 < frames.size(); i16++) {
                            if (!arrayList.contains(frames.get(i16))) {
                                arrayList.add(frames.get(i16));
                            }
                        }
                    }
                }
            }
            return arrayList;
        }

        public void destoryBitmaps() {
            for (int i3 = 0; i3 < this.mFrames.size(); i3++) {
                AnimationTools.destroyDrawable(this.mFrames.valueAt(i3));
            }
            this.mFrames.clear();
        }

        public AnimationInfo(int i3, int i16, int i17) {
            this.mPlay = new ArrayList<>();
            this.mFrames = new SparseArray<>();
            this.mOneCycleFrames = new ArrayList<>();
            this.mInfiniteFromInOnCycle = -1;
            this.mInfiniteToInOnCycle = -1;
            this.mCycle = i3;
            this.mInterval = i16;
            this.mDelay = i17;
            if (i16 <= 0) {
                this.mInterval = 100;
            }
            if (i17 <= 0) {
                this.mDelay = 100;
            }
            this.mInfiniteFromInOnCycle = -1;
            this.mInfiniteToInOnCycle = -1;
        }
    }
}
