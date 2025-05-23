package com.tencent.mobileqq.zplan.minihome;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/zplan/minihome/GuidanceSource;", "", "(Ljava/lang/String;I)V", "getReportSource", "", "SOURCE_PROFILE", "SOURCE_SETTING", "SOURCE_FRIEND_PROFILE", "SOURCE_MINI_HOME_CONNECT", "SOURCE_H5", "zplan_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
public enum GuidanceSource {
    SOURCE_PROFILE { // from class: com.tencent.mobileqq.zplan.minihome.GuidanceSource.SOURCE_PROFILE
        @Override // com.tencent.mobileqq.zplan.minihome.GuidanceSource
        public int getReportSource() {
            return 1;
        }
    },
    SOURCE_SETTING { // from class: com.tencent.mobileqq.zplan.minihome.GuidanceSource.SOURCE_SETTING
        @Override // com.tencent.mobileqq.zplan.minihome.GuidanceSource
        public int getReportSource() {
            return 2;
        }
    },
    SOURCE_FRIEND_PROFILE { // from class: com.tencent.mobileqq.zplan.minihome.GuidanceSource.SOURCE_FRIEND_PROFILE
        @Override // com.tencent.mobileqq.zplan.minihome.GuidanceSource
        public int getReportSource() {
            return 3;
        }
    },
    SOURCE_MINI_HOME_CONNECT { // from class: com.tencent.mobileqq.zplan.minihome.GuidanceSource.SOURCE_MINI_HOME_CONNECT
        @Override // com.tencent.mobileqq.zplan.minihome.GuidanceSource
        public int getReportSource() {
            return 4;
        }
    },
    SOURCE_H5 { // from class: com.tencent.mobileqq.zplan.minihome.GuidanceSource.SOURCE_H5
        @Override // com.tencent.mobileqq.zplan.minihome.GuidanceSource
        public int getReportSource() {
            return 5;
        }
    };

    /* synthetic */ GuidanceSource(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract int getReportSource();
}
