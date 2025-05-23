package com.tencent.tvideo.protocol.pb;

import com.squareup.wire.EnumAdapter;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.Syntax;
import com.squareup.wire.WireEnum;

/* compiled from: P */
/* loaded from: classes27.dex */
public enum AdVRReportType implements WireEnum {
    AD_VR_REPORT_TYPE_UNKNOWN(0),
    AD_VR_REPORT_TYPE_COMMON_EXPOSURE_CLICK(1),
    AD_VR_REPORT_TYPE_HEADER_CLICK(2),
    AD_VR_REPORT_TYPE_ACTION_BTN_CLICK(3),
    AD_VR_REPORT_TYPE_POSTER_CLICK(4),
    AD_VR_REPORT_TYPE_COMMON_PLAY(5),
    AD_VR_REPORT_TYPE_COMMON_DOWNLOAD(6),
    AD_VR_REPORT_TYPE_COMMON(7),
    AD_VR_REPORT_TYPE_SKIP_CLICK(9);

    public static final ProtoAdapter<AdVRReportType> ADAPTER = new EnumAdapter<AdVRReportType>() { // from class: com.tencent.tvideo.protocol.pb.AdVRReportType.a
        {
            Syntax syntax = Syntax.PROTO_3;
            AdVRReportType adVRReportType = AdVRReportType.AD_VR_REPORT_TYPE_UNKNOWN;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.squareup.wire.EnumAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AdVRReportType fromValue(int i3) {
            return AdVRReportType.fromValue(i3);
        }
    };
    private final int value;

    AdVRReportType(int i3) {
        this.value = i3;
    }

    public static AdVRReportType fromValue(int i3) {
        switch (i3) {
            case 0:
                return AD_VR_REPORT_TYPE_UNKNOWN;
            case 1:
                return AD_VR_REPORT_TYPE_COMMON_EXPOSURE_CLICK;
            case 2:
                return AD_VR_REPORT_TYPE_HEADER_CLICK;
            case 3:
                return AD_VR_REPORT_TYPE_ACTION_BTN_CLICK;
            case 4:
                return AD_VR_REPORT_TYPE_POSTER_CLICK;
            case 5:
                return AD_VR_REPORT_TYPE_COMMON_PLAY;
            case 6:
                return AD_VR_REPORT_TYPE_COMMON_DOWNLOAD;
            case 7:
                return AD_VR_REPORT_TYPE_COMMON;
            case 8:
            default:
                return null;
            case 9:
                return AD_VR_REPORT_TYPE_SKIP_CLICK;
        }
    }

    @Override // com.squareup.wire.WireEnum
    public int getValue() {
        return this.value;
    }
}
