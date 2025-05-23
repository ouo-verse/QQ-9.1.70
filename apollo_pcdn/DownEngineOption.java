package apollo_pcdn;

/* compiled from: P */
/* loaded from: classes.dex */
public final class DownEngineOption {
    public static final DownEngineOption kDownEngineEnableHttp302Cahe;
    public static final DownEngineOption kDownEngineEnableHttpLinkPool;
    public static final DownEngineOption kDownEngineLastOption;
    public static final DownEngineOption kDownEngineMaxHttpLinkNum;
    public static final DownEngineOption kDownEngineMaxPcdnLinkNum;
    private static int pcdnNext;
    private static DownEngineOption[] pcdnValues;
    private final String pcdnName;
    private final int pcdnValue;

    static {
        DownEngineOption downEngineOption = new DownEngineOption("kDownEngineMaxHttpLinkNum", apollo_pcdnJNI.kDownEngineMaxHttpLinkNum_get());
        kDownEngineMaxHttpLinkNum = downEngineOption;
        DownEngineOption downEngineOption2 = new DownEngineOption("kDownEngineMaxPcdnLinkNum", apollo_pcdnJNI.kDownEngineMaxPcdnLinkNum_get());
        kDownEngineMaxPcdnLinkNum = downEngineOption2;
        DownEngineOption downEngineOption3 = new DownEngineOption("kDownEngineEnableHttp302Cahe", apollo_pcdnJNI.kDownEngineEnableHttp302Cahe_get());
        kDownEngineEnableHttp302Cahe = downEngineOption3;
        DownEngineOption downEngineOption4 = new DownEngineOption("kDownEngineEnableHttpLinkPool", apollo_pcdnJNI.kDownEngineEnableHttpLinkPool_get());
        kDownEngineEnableHttpLinkPool = downEngineOption4;
        DownEngineOption downEngineOption5 = new DownEngineOption("kDownEngineLastOption");
        kDownEngineLastOption = downEngineOption5;
        pcdnValues = new DownEngineOption[]{downEngineOption, downEngineOption2, downEngineOption3, downEngineOption4, downEngineOption5};
        pcdnNext = 0;
    }

    DownEngineOption(String str) {
        this.pcdnName = str;
        int i3 = pcdnNext;
        pcdnNext = i3 + 1;
        this.pcdnValue = i3;
    }

    public static DownEngineOption pcdnToEnum(int i3) {
        DownEngineOption[] downEngineOptionArr = pcdnValues;
        if (i3 < downEngineOptionArr.length && i3 >= 0) {
            DownEngineOption downEngineOption = downEngineOptionArr[i3];
            if (downEngineOption.pcdnValue == i3) {
                return downEngineOption;
            }
        }
        int i16 = 0;
        while (true) {
            DownEngineOption[] downEngineOptionArr2 = pcdnValues;
            if (i16 < downEngineOptionArr2.length) {
                DownEngineOption downEngineOption2 = downEngineOptionArr2[i16];
                if (downEngineOption2.pcdnValue == i3) {
                    return downEngineOption2;
                }
                i16++;
            } else {
                throw new IllegalArgumentException("No enum " + DownEngineOption.class + " with value " + i3);
            }
        }
    }

    public final int pcdnValue() {
        return this.pcdnValue;
    }

    public String toString() {
        return this.pcdnName;
    }

    DownEngineOption(String str, int i3) {
        this.pcdnName = str;
        this.pcdnValue = i3;
        pcdnNext = i3 + 1;
    }

    DownEngineOption(String str, DownEngineOption downEngineOption) {
        this.pcdnName = str;
        int i3 = downEngineOption.pcdnValue;
        this.pcdnValue = i3;
        pcdnNext = i3 + 1;
    }
}
