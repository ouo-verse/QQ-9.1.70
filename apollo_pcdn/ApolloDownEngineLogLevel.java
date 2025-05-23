package apollo_pcdn;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ApolloDownEngineLogLevel {
    public static final ApolloDownEngineLogLevel ADEL_Pri_Debug;
    public static final ApolloDownEngineLogLevel ADEL_Pri_Error;
    public static final ApolloDownEngineLogLevel ADEL_Pri_Event;
    public static final ApolloDownEngineLogLevel ADEL_Pri_Info;
    public static final ApolloDownEngineLogLevel ADEL_Pri_None;
    public static final ApolloDownEngineLogLevel ADEL_Pri_Warning;
    private static int pcdnNext;
    private static ApolloDownEngineLogLevel[] pcdnValues;
    private final String pcdnName;
    private final int pcdnValue;

    static {
        ApolloDownEngineLogLevel apolloDownEngineLogLevel = new ApolloDownEngineLogLevel("ADEL_Pri_Debug");
        ADEL_Pri_Debug = apolloDownEngineLogLevel;
        ApolloDownEngineLogLevel apolloDownEngineLogLevel2 = new ApolloDownEngineLogLevel("ADEL_Pri_Info");
        ADEL_Pri_Info = apolloDownEngineLogLevel2;
        ApolloDownEngineLogLevel apolloDownEngineLogLevel3 = new ApolloDownEngineLogLevel("ADEL_Pri_Warning");
        ADEL_Pri_Warning = apolloDownEngineLogLevel3;
        ApolloDownEngineLogLevel apolloDownEngineLogLevel4 = new ApolloDownEngineLogLevel("ADEL_Pri_Event");
        ADEL_Pri_Event = apolloDownEngineLogLevel4;
        ApolloDownEngineLogLevel apolloDownEngineLogLevel5 = new ApolloDownEngineLogLevel("ADEL_Pri_Error");
        ADEL_Pri_Error = apolloDownEngineLogLevel5;
        ApolloDownEngineLogLevel apolloDownEngineLogLevel6 = new ApolloDownEngineLogLevel("ADEL_Pri_None");
        ADEL_Pri_None = apolloDownEngineLogLevel6;
        pcdnValues = new ApolloDownEngineLogLevel[]{apolloDownEngineLogLevel, apolloDownEngineLogLevel2, apolloDownEngineLogLevel3, apolloDownEngineLogLevel4, apolloDownEngineLogLevel5, apolloDownEngineLogLevel6};
        pcdnNext = 0;
    }

    ApolloDownEngineLogLevel(String str) {
        this.pcdnName = str;
        int i3 = pcdnNext;
        pcdnNext = i3 + 1;
        this.pcdnValue = i3;
    }

    public static ApolloDownEngineLogLevel pcdnToEnum(int i3) {
        ApolloDownEngineLogLevel[] apolloDownEngineLogLevelArr = pcdnValues;
        if (i3 < apolloDownEngineLogLevelArr.length && i3 >= 0) {
            ApolloDownEngineLogLevel apolloDownEngineLogLevel = apolloDownEngineLogLevelArr[i3];
            if (apolloDownEngineLogLevel.pcdnValue == i3) {
                return apolloDownEngineLogLevel;
            }
        }
        int i16 = 0;
        while (true) {
            ApolloDownEngineLogLevel[] apolloDownEngineLogLevelArr2 = pcdnValues;
            if (i16 < apolloDownEngineLogLevelArr2.length) {
                ApolloDownEngineLogLevel apolloDownEngineLogLevel2 = apolloDownEngineLogLevelArr2[i16];
                if (apolloDownEngineLogLevel2.pcdnValue == i3) {
                    return apolloDownEngineLogLevel2;
                }
                i16++;
            } else {
                throw new IllegalArgumentException("No enum " + ApolloDownEngineLogLevel.class + " with value " + i3);
            }
        }
    }

    public final int pcdnValue() {
        return this.pcdnValue;
    }

    public String toString() {
        return this.pcdnName;
    }

    ApolloDownEngineLogLevel(String str, int i3) {
        this.pcdnName = str;
        this.pcdnValue = i3;
        pcdnNext = i3 + 1;
    }

    ApolloDownEngineLogLevel(String str, ApolloDownEngineLogLevel apolloDownEngineLogLevel) {
        this.pcdnName = str;
        int i3 = apolloDownEngineLogLevel.pcdnValue;
        this.pcdnValue = i3;
        pcdnNext = i3 + 1;
    }
}
