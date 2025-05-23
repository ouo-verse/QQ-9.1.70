package apollo_pcdn;

/* compiled from: P */
/* loaded from: classes.dex */
public class apollo_pcdn implements apollo_pcdnConstants {
    public static IDownEngine CreateDownEngine() {
        long CreateDownEngine = apollo_pcdnJNI.CreateDownEngine();
        if (CreateDownEngine == 0) {
            return null;
        }
        return new IDownEngine(CreateDownEngine, false);
    }

    public static void DestoryDownEngine(PP_IDownEngine pP_IDownEngine) {
        apollo_pcdnJNI.DestoryDownEngine(PP_IDownEngine.getCPtr(pP_IDownEngine));
    }

    public static void NotifyBackGroundSwitch(boolean z16) {
        apollo_pcdnJNI.NotifyBackGroundSwitch(z16);
    }
}
