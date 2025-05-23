package com.tencent.mapsdk.internal;

import com.tencent.mapsdk.core.components.protocol.jce.trafficevent.Detail;
import com.tencent.tencentmap.mapsdk.maps.model.TrafficEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class ry implements TrafficEvent {

    /* renamed from: a, reason: collision with root package name */
    private static final String f150158a = "yyyy/MM/dd HH\u65f6";

    /* renamed from: c, reason: collision with root package name */
    private static final String[] f150159c = {"\u4ea4\u901a\u4e8b\u6545", "\u4ea4\u901a\u7ba1\u5236", "\u9053\u8def\u65bd\u5de5", "\u8def\u4e0a\u969c\u788d\u7269", "\u6d3b\u52a8", "\u6076\u52a3\u5929\u6c14", "\u707e\u5bb3", "\u62e5\u5835", "\u68c0\u67e5", "\u4e00\u822c\u4e8b\u6545", "\u79ef\u6c34", "\u5176\u4ed6\u4e8b\u4ef6"};

    /* renamed from: d, reason: collision with root package name */
    private static final String[] f150160d = {"\u53d1\u751f", "\u51fa\u73b0", "\u6709", "\u6709", "\u6709", "\u51fa\u73b0", "\u6709", "\u51fa\u73b0", "\u6709", "\u53d1\u751f", "\u6709", "\u6709"};

    /* renamed from: b, reason: collision with root package name */
    private Detail f150161b;

    public ry(Detail detail) {
        this.f150161b = detail;
    }

    private Detail a() {
        return this.f150161b;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.TrafficEvent
    public final String getDescription() {
        String str;
        int i3 = this.f150161b.basic.type;
        if (i3 > f150159c.length) {
            str = f150160d[r1.length - 1];
        } else {
            str = f150160d[i3 - 1];
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(f150158a, Locale.US);
        return simpleDateFormat.format(new Date(this.f150161b.basic.start_time * 1000)) + " - " + simpleDateFormat.format(new Date(this.f150161b.basic.end_time * 1000)) + '\uff0c' + getRoadName() + str + getType();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.TrafficEvent
    public final int getEndTime() {
        return this.f150161b.basic.end_time;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.TrafficEvent
    public final String getMessage() {
        return this.f150161b.basic.message;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.TrafficEvent
    public final String getRoadName() {
        return this.f150161b.basic.roadname;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.TrafficEvent
    public final String getSource() {
        return this.f150161b.basic.source;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.TrafficEvent
    public final int getStartTime() {
        return this.f150161b.basic.start_time;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.TrafficEvent
    public final String getType() {
        int i3 = this.f150161b.basic.type;
        String[] strArr = f150159c;
        if (i3 > strArr.length) {
            return strArr[strArr.length - 1];
        }
        return strArr[i3 - 1];
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.TrafficEvent
    public final int getUpdateTime() {
        return this.f150161b.basic.update_time;
    }
}
