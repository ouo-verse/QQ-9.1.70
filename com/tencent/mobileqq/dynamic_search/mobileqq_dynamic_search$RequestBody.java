package com.tencent.mobileqq.dynamic_search;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class mobileqq_dynamic_search$RequestBody extends MessageMicro<mobileqq_dynamic_search$RequestBody> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_cookie;
    public final PBUInt32Field cmd = PBField.initUInt32(0);
    public mobileqq_dynamic_search$ExtensionRequestInfo extension_request_info;
    public final PBBytesField key_word;
    public final PBBytesField result_id;
    public mobileqq_dynamic_search$RootSearcherRequest search_request;
    public final PBBytesField version;

    static {
        String[] strArr = {"cmd", QCircleSchemeAttr.Detail.KEY_WORD, "search_request", "extension_request_info", "result_id", "version", "bytes_cookie"};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50, 58}, strArr, new Object[]{0, byteStringMicro, null, null, byteStringMicro, byteStringMicro, byteStringMicro}, mobileqq_dynamic_search$RequestBody.class);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.tencent.mobileqq.dynamic_search.mobileqq_dynamic_search$RootSearcherRequest] */
    /* JADX WARN: Type inference failed for: r1v2, types: [com.tencent.mobileqq.dynamic_search.mobileqq_dynamic_search$ExtensionRequestInfo] */
    public mobileqq_dynamic_search$RequestBody() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.key_word = PBField.initBytes(byteStringMicro);
        this.search_request = new MessageMicro<mobileqq_dynamic_search$RootSearcherRequest>() { // from class: com.tencent.mobileqq.dynamic_search.mobileqq_dynamic_search$RootSearcherRequest
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 58}, new String[]{"ver", "business", "start_index", "page_size", "busi_mask", "req_ctrl_type", "plugin_state"}, new Object[]{0, 0, 0, 3, -1L, 0, null}, mobileqq_dynamic_search$RootSearcherRequest.class);
            public final PBUInt32Field ver = PBField.initUInt32(0);
            public final PBEnumField business = PBField.initEnum(0);
            public final PBInt32Field start_index = PBField.initInt32(0);
            public final PBInt32Field page_size = PBField.initInt32(3);
            public final PBInt64Field busi_mask = PBField.initInt64(-1);
            public final PBEnumField req_ctrl_type = PBField.initEnum(0);
            public final PBRepeatMessageField<mobileqq_dynamic_search$PluginState> plugin_state = PBField.initRepeatMessage(mobileqq_dynamic_search$PluginState.class);
        };
        this.extension_request_info = new MessageMicro<mobileqq_dynamic_search$ExtensionRequestInfo>() { // from class: com.tencent.mobileqq.dynamic_search.mobileqq_dynamic_search$ExtensionRequestInfo
            static final MessageMicro.FieldMap __fieldMap__;
            public final PBBytesField action;
            public final PBBytesField city;
            public final PBFloatField latitude;
            public final PBFloatField longitude;
            public final PBInt32Field radius;
            public final PBBytesField region;

            static {
                String[] strArr = {"action", "latitude", "longitude", "radius", "city", TtmlNode.TAG_REGION};
                ByteStringMicro byteStringMicro2 = ByteStringMicro.EMPTY;
                Float valueOf = Float.valueOf(0.0f);
                __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 21, 29, 32, 42, 50}, strArr, new Object[]{byteStringMicro2, valueOf, valueOf, 0, byteStringMicro2, byteStringMicro2}, mobileqq_dynamic_search$ExtensionRequestInfo.class);
            }

            {
                ByteStringMicro byteStringMicro2 = ByteStringMicro.EMPTY;
                this.action = PBField.initBytes(byteStringMicro2);
                this.latitude = PBField.initFloat(0.0f);
                this.longitude = PBField.initFloat(0.0f);
                this.radius = PBField.initInt32(0);
                this.city = PBField.initBytes(byteStringMicro2);
                this.region = PBField.initBytes(byteStringMicro2);
            }
        };
        this.result_id = PBField.initBytes(byteStringMicro);
        this.version = PBField.initBytes(byteStringMicro);
        this.bytes_cookie = PBField.initBytes(byteStringMicro);
    }
}
