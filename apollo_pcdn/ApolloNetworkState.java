package apollo_pcdn;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ApolloNetworkState {
    public static final ApolloNetworkState kApolloNetTypeCount;
    public static final ApolloNetworkState kApolloNotReachable;
    public static final ApolloNetworkState kApolloReachableViaEthernet;
    public static final ApolloNetworkState kApolloReachableViaWWAN;
    public static final ApolloNetworkState kApolloReachableViaWiFi;
    private static int pcdnNext;
    private static ApolloNetworkState[] pcdnValues;
    private final String pcdnName;
    private final int pcdnValue;

    static {
        ApolloNetworkState apolloNetworkState = new ApolloNetworkState("kApolloNotReachable", apollo_pcdnJNI.kApolloNotReachable_get());
        kApolloNotReachable = apolloNetworkState;
        ApolloNetworkState apolloNetworkState2 = new ApolloNetworkState("kApolloReachableViaWWAN");
        kApolloReachableViaWWAN = apolloNetworkState2;
        ApolloNetworkState apolloNetworkState3 = new ApolloNetworkState("kApolloReachableViaWiFi");
        kApolloReachableViaWiFi = apolloNetworkState3;
        ApolloNetworkState apolloNetworkState4 = new ApolloNetworkState("kApolloReachableViaEthernet");
        kApolloReachableViaEthernet = apolloNetworkState4;
        ApolloNetworkState apolloNetworkState5 = new ApolloNetworkState("kApolloNetTypeCount");
        kApolloNetTypeCount = apolloNetworkState5;
        pcdnValues = new ApolloNetworkState[]{apolloNetworkState, apolloNetworkState2, apolloNetworkState3, apolloNetworkState4, apolloNetworkState5};
        pcdnNext = 0;
    }

    ApolloNetworkState(String str) {
        this.pcdnName = str;
        int i3 = pcdnNext;
        pcdnNext = i3 + 1;
        this.pcdnValue = i3;
    }

    public static ApolloNetworkState pcdnToEnum(int i3) {
        ApolloNetworkState[] apolloNetworkStateArr = pcdnValues;
        if (i3 < apolloNetworkStateArr.length && i3 >= 0) {
            ApolloNetworkState apolloNetworkState = apolloNetworkStateArr[i3];
            if (apolloNetworkState.pcdnValue == i3) {
                return apolloNetworkState;
            }
        }
        int i16 = 0;
        while (true) {
            ApolloNetworkState[] apolloNetworkStateArr2 = pcdnValues;
            if (i16 < apolloNetworkStateArr2.length) {
                ApolloNetworkState apolloNetworkState2 = apolloNetworkStateArr2[i16];
                if (apolloNetworkState2.pcdnValue == i3) {
                    return apolloNetworkState2;
                }
                i16++;
            } else {
                throw new IllegalArgumentException("No enum " + ApolloNetworkState.class + " with value " + i3);
            }
        }
    }

    public final int pcdnValue() {
        return this.pcdnValue;
    }

    public String toString() {
        return this.pcdnName;
    }

    ApolloNetworkState(String str, int i3) {
        this.pcdnName = str;
        this.pcdnValue = i3;
        pcdnNext = i3 + 1;
    }

    ApolloNetworkState(String str, ApolloNetworkState apolloNetworkState) {
        this.pcdnName = str;
        int i3 = apolloNetworkState.pcdnValue;
        this.pcdnValue = i3;
        pcdnNext = i3 + 1;
    }
}
