package com.tencent.robot.adelie.homepage.maintab;

import common.config.service.QzoneConfig;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Marker;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0003j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b\u00a8\u0006\t"}, d2 = {"Lcom/tencent/robot/adelie/homepage/maintab/TabType;", "", "name", "", "(Ljava/lang/String;ILjava/lang/String;)V", "toReportValue", "DISCOVERY", "CREATE", "MINE", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes25.dex */
public enum TabType {
    DISCOVERY(QzoneConfig.DefaultValue.DEFAULT_DISCOVERY_TITLE),
    CREATE(Marker.ANY_NON_NULL_MARKER),
    MINE("\u6211\u7684");

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes25.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f366403a;

        static {
            int[] iArr = new int[TabType.values().length];
            try {
                iArr[TabType.DISCOVERY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TabType.MINE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[TabType.CREATE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f366403a = iArr;
        }
    }

    TabType(String str) {
    }

    @NotNull
    public final String toReportValue() {
        int i3 = a.f366403a[ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    return "2";
                }
                throw new NoWhenBranchMatchedException();
            }
            return "3";
        }
        return "1";
    }
}
