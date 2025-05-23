package com.tencent.mobileqq.ar.arcloud.pb;

import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class YoutuOcr$OcrItem extends MessageMicro<YoutuOcr$OcrItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"itemstring", "itemcoord"}, new Object[]{"", null}, YoutuOcr$OcrItem.class);
    public final PBStringField itemstring = PBField.initString("");
    public YoutuOcr$ItemCoord itemcoord = new MessageMicro<YoutuOcr$ItemCoord>() { // from class: com.tencent.mobileqq.ar.arcloud.pb.YoutuOcr$ItemCoord
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{HippyTKDListViewAdapter.X, "y", "width", "height"}, new Object[]{0, 0, 0, 0}, YoutuOcr$ItemCoord.class);

        /* renamed from: x, reason: collision with root package name */
        public final PBInt32Field f197730x = PBField.initInt32(0);

        /* renamed from: y, reason: collision with root package name */
        public final PBInt32Field f197731y = PBField.initInt32(0);
        public final PBInt32Field width = PBField.initInt32(0);
        public final PBInt32Field height = PBField.initInt32(0);
    };
}
