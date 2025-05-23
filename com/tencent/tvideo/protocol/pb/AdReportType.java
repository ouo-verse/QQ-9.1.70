package com.tencent.tvideo.protocol.pb;

import com.squareup.wire.EnumAdapter;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.Syntax;
import com.squareup.wire.WireEnum;

/* compiled from: P */
/* loaded from: classes27.dex */
public enum AdReportType implements WireEnum {
    AD_REPORT_TYPE_UNKNOWN(0),
    AD_REPORT_TYPE_ORIGIN_EXPOSURE(1),
    AD_REPORT_TYPE_EXPOSURE(2),
    AD_REPORT_TYPE_PLAY_BACK(3),
    AD_REPORT_TYPE_EMPTY(4),
    AD_REPORT_TYPE_EFFECT(5),
    AD_REPORT_TYPE_FEEDBACK(6),
    AD_REPORT_TYPE_CLICK(7);

    public static final ProtoAdapter<AdReportType> ADAPTER = new EnumAdapter<AdReportType>() { // from class: com.tencent.tvideo.protocol.pb.AdReportType.a
        {
            Syntax syntax = Syntax.PROTO_3;
            AdReportType adReportType = AdReportType.AD_REPORT_TYPE_UNKNOWN;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.squareup.wire.EnumAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AdReportType fromValue(int i3) {
            return AdReportType.fromValue(i3);
        }
    };
    private final int value;

    AdReportType(int i3) {
        this.value = i3;
    }

    public static AdReportType fromValue(int i3) {
        switch (i3) {
            case 0:
                return AD_REPORT_TYPE_UNKNOWN;
            case 1:
                return AD_REPORT_TYPE_ORIGIN_EXPOSURE;
            case 2:
                return AD_REPORT_TYPE_EXPOSURE;
            case 3:
                return AD_REPORT_TYPE_PLAY_BACK;
            case 4:
                return AD_REPORT_TYPE_EMPTY;
            case 5:
                return AD_REPORT_TYPE_EFFECT;
            case 6:
                return AD_REPORT_TYPE_FEEDBACK;
            case 7:
                return AD_REPORT_TYPE_CLICK;
            default:
                return null;
        }
    }

    @Override // com.squareup.wire.WireEnum
    public int getValue() {
        return this.value;
    }
}
