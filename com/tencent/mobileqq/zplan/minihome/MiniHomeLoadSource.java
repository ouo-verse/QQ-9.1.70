package com.tencent.mobileqq.zplan.minihome;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/zplan/minihome/MiniHomeLoadSource;", "", "(Ljava/lang/String;I)V", "getResportString", "", "RESUME", "UPDATE_COVER", "REUQEST_MINI_HOME", "APPERANCE_CHANGE", "zplan_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
public enum MiniHomeLoadSource {
    RESUME { // from class: com.tencent.mobileqq.zplan.minihome.MiniHomeLoadSource.RESUME
        @Override // com.tencent.mobileqq.zplan.minihome.MiniHomeLoadSource
        @NotNull
        public String getResportString() {
            return "onResume";
        }
    },
    UPDATE_COVER { // from class: com.tencent.mobileqq.zplan.minihome.MiniHomeLoadSource.UPDATE_COVER
        @Override // com.tencent.mobileqq.zplan.minihome.MiniHomeLoadSource
        @NotNull
        public String getResportString() {
            return "updateCover";
        }
    },
    REUQEST_MINI_HOME { // from class: com.tencent.mobileqq.zplan.minihome.MiniHomeLoadSource.REUQEST_MINI_HOME
        @Override // com.tencent.mobileqq.zplan.minihome.MiniHomeLoadSource
        @NotNull
        public String getResportString() {
            return "requestMiniHomeInfo";
        }
    },
    APPERANCE_CHANGE { // from class: com.tencent.mobileqq.zplan.minihome.MiniHomeLoadSource.APPERANCE_CHANGE
        @Override // com.tencent.mobileqq.zplan.minihome.MiniHomeLoadSource
        @NotNull
        public String getResportString() {
            return "appearance_chg";
        }
    };

    /* synthetic */ MiniHomeLoadSource(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @NotNull
    public abstract String getResportString();
}
