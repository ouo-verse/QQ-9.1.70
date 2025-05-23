package com.tencent.mobileqq.search.searchdetail;

import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\r\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001b\u001a\u00020\u0016\u00a2\u0006\u0004\b!\u0010\"J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0001H\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016J\u0011\u0010\r\u001a\u0004\u0018\u00010\fH\u0016\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0002H\u0016J\b\u0010\u0011\u001a\u00020\u0002H\u0016J\u0010\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0002H\u0016J\b\u0010\u0014\u001a\u00020\u0002H\u0016J\u0010\u0010\u0015\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0001H&R\u0017\u0010\u001b\u001a\u00020\u00168\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001e\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010 \u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u001d\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/a;", "Lcom/tencent/mobileqq/search/searchdetail/c;", "", "getItemType", "", "getItemId", "", "i", "newItem", "", "b", "k", "", "l", "()Ljava/lang/Long;", WidgetCacheConstellationData.NUM, "c", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "position", "o", DomainData.DOMAIN_NAME, "a", "Lcom/tencent/mobileqq/search/searchdetail/b;", "d", "Lcom/tencent/mobileqq/search/searchdetail/b;", "j", "()Lcom/tencent/mobileqq/search/searchdetail/b;", "commonInfo", "e", "I", "pageNum", "f", "withoutTitlePosition", "<init>", "(Lcom/tencent/mobileqq/search/searchdetail/b;)V", "qqsearch-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public abstract class a implements c {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CommonInfo commonInfo;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int pageNum;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int withoutTitlePosition;

    public a(@NotNull CommonInfo commonInfo) {
        Intrinsics.checkNotNullParameter(commonInfo, "commonInfo");
        this.commonInfo = commonInfo;
        this.pageNum = -1;
        this.withoutTitlePosition = -1;
    }

    @Override // com.tencent.mobileqq.search.searchdetail.c
    public abstract boolean a(@NotNull c newItem);

    @Override // com.tencent.mobileqq.search.searchdetail.c
    public boolean b(@NotNull c newItem) {
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        if (newItem == this) {
            return true;
        }
        if (Intrinsics.areEqual(newItem.getItemId(), getItemId()) && newItem.getItemType() == getItemType()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.search.searchdetail.c
    public void c(int num) {
        this.pageNum = num;
    }

    @Override // com.tencent.mobileqq.search.searchdetail.c
    @NotNull
    public String getItemId() {
        return this.commonInfo.getItemId();
    }

    @Override // com.tencent.mobileqq.search.searchdetail.c
    public abstract int getItemType();

    @NotNull
    /* renamed from: j, reason: from getter */
    public final CommonInfo getCommonInfo() {
        return this.commonInfo;
    }

    @NotNull
    public String k() {
        return "";
    }

    @Nullable
    public Long l() {
        return null;
    }

    /* renamed from: m, reason: from getter */
    public int getPageNum() {
        return this.pageNum;
    }

    /* renamed from: n, reason: from getter */
    public int getWithoutTitlePosition() {
        return this.withoutTitlePosition;
    }

    public void o(int position) {
        this.withoutTitlePosition = position;
    }

    @Override // com.tencent.mobileqq.search.searchdetail.c
    public void i() {
    }
}
