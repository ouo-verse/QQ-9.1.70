package QMF_PROTOCAL;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes.dex */
public final class eGetConfigScene implements Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int _SQGetConfigApnChanged = 101;
    public static final int _SQGetConfigAppStart = 100;
    public static final int _SQGetConfigAppTimer = 102;
    public static final int _SQGetConfigFromBackToFront = 103;
    public static final int _SQGetConfigRecvDelPush = 104;
    public static final int _SceneAppActivate = 1;
    public static final int _SceneAppRun = 0;
    public static final int _SceneNetworkChanged = 3;
    public static final int _SceneTimeout = 2;
    private String __T;
    private int __value;
    private static eGetConfigScene[] __values = new eGetConfigScene[8];
    public static final eGetConfigScene SceneAppRun = new eGetConfigScene(0, 0, "SceneAppRun");
    public static final eGetConfigScene SceneAppActivate = new eGetConfigScene(1, 1, "SceneAppActivate");
    public static final eGetConfigScene SceneTimeout = new eGetConfigScene(2, 2, "SceneTimeout");
    public static final eGetConfigScene SceneNetworkChanged = new eGetConfigScene(3, 3, "SceneNetworkChanged");
    public static final eGetConfigScene SQGetConfigAppStart = new eGetConfigScene(4, 100, "SQGetConfigAppStart");
    public static final eGetConfigScene SQGetConfigApnChanged = new eGetConfigScene(5, 101, "SQGetConfigApnChanged");
    public static final eGetConfigScene SQGetConfigAppTimer = new eGetConfigScene(6, 102, "SQGetConfigAppTimer");
    public static final eGetConfigScene SQGetConfigFromBackToFront = new eGetConfigScene(7, 103, "SQGetConfigFromBackToFront");
    public static final eGetConfigScene SQGetConfigRecvDelPush = new eGetConfigScene(8, 104, "SQGetConfigRecvDelPush");

    eGetConfigScene(int i3, int i16, String str) {
        new String();
        this.__T = str;
        this.__value = i16;
        __values[i3] = this;
    }

    public static eGetConfigScene convert(int i3) {
        int i16 = 0;
        while (true) {
            eGetConfigScene[] egetconfigsceneArr = __values;
            if (i16 >= egetconfigsceneArr.length) {
                return null;
            }
            if (egetconfigsceneArr[i16].value() == i3) {
                return __values[i16];
            }
            i16++;
        }
    }

    public String toString() {
        return this.__T;
    }

    public int value() {
        return this.__value;
    }

    public static eGetConfigScene convert(String str) {
        int i3 = 0;
        while (true) {
            eGetConfigScene[] egetconfigsceneArr = __values;
            if (i3 >= egetconfigsceneArr.length) {
                return null;
            }
            if (egetconfigsceneArr[i3].toString().equals(str)) {
                return __values[i3];
            }
            i3++;
        }
    }
}
