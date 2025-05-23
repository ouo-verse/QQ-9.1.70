package com.tencent.weiyun.utils;

import NS_COMM.COMM;
import android.content.Context;
import android.graphics.Point;
import android.util.Log;
import android.util.SparseArray;
import android.view.WindowManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes27.dex */
public class UIHelper {
    static IPatchRedirector $redirector_ = null;
    private static final Object SCREEN_SIZE_LOCK;
    private static final String TAG = "UIHelper";
    private static final SparseArray<String> THUMBNAIL_SPEC;
    private static final String VIDEO_THUMB_SPEC_MIDDLE = "/128";
    private static final String VIDEO_THUMB_SPEC_XLARGE = "/640";
    private static volatile int WINDOW_SCREEN_HEIGHT_LAND;
    private static volatile String WINDOW_SCREEN_SIZE_LAND;
    private static volatile String WINDOW_SCREEN_SIZE_PORT;
    private static volatile int WINDOW_SCREEN_WIDTH_LAND;

    /* compiled from: P */
    /* renamed from: com.tencent.weiyun.utils.UIHelper$1, reason: invalid class name */
    /* loaded from: classes27.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$tencent$weiyun$utils$UIHelper$ThumbnailSpec;
        static IPatchRedirector $redirector_;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11072);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[ThumbnailSpec.values().length];
            $SwitchMap$com$tencent$weiyun$utils$UIHelper$ThumbnailSpec = iArr;
            try {
                iArr[ThumbnailSpec.SMALL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$tencent$weiyun$utils$UIHelper$ThumbnailSpec[ThumbnailSpec.MIDDLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$tencent$weiyun$utils$UIHelper$ThumbnailSpec[ThumbnailSpec.LARGE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$tencent$weiyun$utils$UIHelper$ThumbnailSpec[ThumbnailSpec.XLARGE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$tencent$weiyun$utils$UIHelper$ThumbnailSpec[ThumbnailSpec.XXLARGE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$tencent$weiyun$utils$UIHelper$ThumbnailSpec[ThumbnailSpec.SCREEN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class ThumbnailSpec {
        private static final /* synthetic */ ThumbnailSpec[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final ThumbnailSpec LARGE;
        public static final ThumbnailSpec MIDDLE;
        public static final ThumbnailSpec SCREEN;
        public static final ThumbnailSpec SMALL;
        public static final ThumbnailSpec XLARGE;
        public static final ThumbnailSpec XXLARGE;
        private final int key;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(COMM.mini_app_mdebug);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 3)) {
                redirector.redirect((short) 3);
                return;
            }
            ThumbnailSpec thumbnailSpec = new ThumbnailSpec("SMALL", 0, 1);
            SMALL = thumbnailSpec;
            ThumbnailSpec thumbnailSpec2 = new ThumbnailSpec("MIDDLE", 1, 2);
            MIDDLE = thumbnailSpec2;
            ThumbnailSpec thumbnailSpec3 = new ThumbnailSpec("LARGE", 2, 3);
            LARGE = thumbnailSpec3;
            ThumbnailSpec thumbnailSpec4 = new ThumbnailSpec("XLARGE", 3, 4);
            XLARGE = thumbnailSpec4;
            ThumbnailSpec thumbnailSpec5 = new ThumbnailSpec("XXLARGE", 4, 5);
            XXLARGE = thumbnailSpec5;
            ThumbnailSpec thumbnailSpec6 = new ThumbnailSpec("SCREEN", 5, 6);
            SCREEN = thumbnailSpec6;
            $VALUES = new ThumbnailSpec[]{thumbnailSpec, thumbnailSpec2, thumbnailSpec3, thumbnailSpec4, thumbnailSpec5, thumbnailSpec6};
        }

        ThumbnailSpec(String str, int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
            } else {
                this.key = i16;
            }
        }

        public static int size() {
            return 6;
        }

        public static ThumbnailSpec valueOf(String str) {
            return (ThumbnailSpec) Enum.valueOf(ThumbnailSpec.class, str);
        }

        public static ThumbnailSpec[] values() {
            return (ThumbnailSpec[]) $VALUES.clone();
        }

        public int value() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return this.key;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(10251);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        WINDOW_SCREEN_WIDTH_LAND = -1;
        WINDOW_SCREEN_HEIGHT_LAND = -1;
        WINDOW_SCREEN_SIZE_LAND = "";
        WINDOW_SCREEN_SIZE_PORT = "";
        SCREEN_SIZE_LOCK = new Object();
        SparseArray<String> sparseArray = new SparseArray<>(ThumbnailSpec.size());
        THUMBNAIL_SPEC = sparseArray;
        sparseArray.put(ThumbnailSpec.SMALL.value(), "64*64");
        sparseArray.put(ThumbnailSpec.MIDDLE.value(), "128*128");
        sparseArray.put(ThumbnailSpec.LARGE.value(), "256*256");
        sparseArray.put(ThumbnailSpec.XLARGE.value(), "640*640");
        sparseArray.put(ThumbnailSpec.XXLARGE.value(), "1024*1024");
    }

    public UIHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static String getThumbnailSpec(Context context, ThumbnailSpec thumbnailSpec) {
        if (ThumbnailSpec.SCREEN.value() == thumbnailSpec.value()) {
            if (context != null) {
                return getWindowScreenSizeStr(context);
            }
            return THUMBNAIL_SPEC.get(ThumbnailSpec.XXLARGE.value());
        }
        return THUMBNAIL_SPEC.get(thumbnailSpec.value());
    }

    public static String getVideoThumbSpec(ThumbnailSpec thumbnailSpec) {
        int i3 = AnonymousClass1.$SwitchMap$com$tencent$weiyun$utils$UIHelper$ThumbnailSpec[thumbnailSpec.ordinal()];
        if (i3 != 1 && i3 != 2) {
            return VIDEO_THUMB_SPEC_XLARGE;
        }
        return VIDEO_THUMB_SPEC_MIDDLE;
    }

    public static int getWindowScreenHeight(Context context) {
        boolean z16;
        getWindowScreenSize(context);
        if (context.getResources().getConfiguration().orientation == 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return WINDOW_SCREEN_HEIGHT_LAND;
        }
        return WINDOW_SCREEN_WIDTH_LAND;
    }

    private static void getWindowScreenSize(Context context) {
        boolean z16;
        int i3;
        int i16;
        synchronized (SCREEN_SIZE_LOCK) {
            if (WINDOW_SCREEN_WIDTH_LAND < 0 || WINDOW_SCREEN_HEIGHT_LAND < 0) {
                WindowManager windowManager = (WindowManager) context.getSystemService("window");
                if (context.getResources().getConfiguration().orientation == 2) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                Point point = new Point();
                windowManager.getDefaultDisplay().getSize(point);
                if (z16) {
                    i3 = point.x;
                } else {
                    i3 = point.y;
                }
                WINDOW_SCREEN_WIDTH_LAND = i3;
                if (z16) {
                    i16 = point.y;
                } else {
                    i16 = point.x;
                }
                WINDOW_SCREEN_HEIGHT_LAND = i16;
                WINDOW_SCREEN_SIZE_LAND = Integer.toString(WINDOW_SCREEN_WIDTH_LAND) + '*' + Integer.toString(WINDOW_SCREEN_HEIGHT_LAND);
                WINDOW_SCREEN_SIZE_PORT = Integer.toString(WINDOW_SCREEN_HEIGHT_LAND) + '*' + Integer.toString(WINDOW_SCREEN_WIDTH_LAND);
                Log.d(TAG, "Get ScreenSize(lw=" + WINDOW_SCREEN_WIDTH_LAND + ", lh=" + WINDOW_SCREEN_HEIGHT_LAND + ")");
            }
        }
    }

    public static String getWindowScreenSizeStr(Context context) {
        boolean z16;
        getWindowScreenSize(context);
        if (context.getResources().getConfiguration().orientation == 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return WINDOW_SCREEN_SIZE_LAND;
        }
        return WINDOW_SCREEN_SIZE_PORT;
    }

    public static int getWindowScreenWidth(Context context) {
        boolean z16;
        getWindowScreenSize(context);
        if (context.getResources().getConfiguration().orientation == 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return WINDOW_SCREEN_WIDTH_LAND;
        }
        return WINDOW_SCREEN_HEIGHT_LAND;
    }
}
