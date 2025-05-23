package com.tencent.sqshow.zootopia.nativeui.data.repo;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import uv4.bk;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\r\u00a2\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\f\u001a\u0004\u0018\u00010\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0019\u0010\u0010\u001a\u0004\u0018\u00010\r8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u000e\u001a\u0004\b\u0003\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/data/repo/g;", "", "", "a", "I", "c", "()I", "type", "Luv4/bk;", "b", "Luv4/bk;", "()Luv4/bk;", "storeTypeItem", "", "Ljava/lang/String;", "()Ljava/lang/String;", "recommendText", "<init>", "(ILuv4/bk;Ljava/lang/String;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int type;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final bk storeTypeItem;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final String recommendText;

    public g(int i3, bk bkVar, String str) {
        this.type = i3;
        this.storeTypeItem = bkVar;
        this.recommendText = str;
    }

    /* renamed from: a, reason: from getter */
    public final String getRecommendText() {
        return this.recommendText;
    }

    /* renamed from: b, reason: from getter */
    public final bk getStoreTypeItem() {
        return this.storeTypeItem;
    }

    /* renamed from: c, reason: from getter */
    public final int getType() {
        return this.type;
    }

    public /* synthetic */ g(int i3, bk bkVar, String str, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, (i16 & 2) != 0 ? null : bkVar, (i16 & 4) != 0 ? null : str);
    }
}
