package com.tencent.mobileqq.partner.signin;

import com.tencent.mobileqq.partner.signin.pb.GeneralSigninPB$BusSigninDetail;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\t\u001a\u0004\b\u0003\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/partner/signin/k;", "", "", "a", "I", "b", "()I", "errCode", "Lcom/tencent/mobileqq/partner/signin/pb/GeneralSigninPB$BusSigninDetail;", "Lcom/tencent/mobileqq/partner/signin/pb/GeneralSigninPB$BusSigninDetail;", "()Lcom/tencent/mobileqq/partner/signin/pb/GeneralSigninPB$BusSigninDetail;", "detail", "<init>", "(ILcom/tencent/mobileqq/partner/signin/pb/GeneralSigninPB$BusSigninDetail;)V", "mutualmark_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int errCode;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final GeneralSigninPB$BusSigninDetail detail;

    public k(int i3, GeneralSigninPB$BusSigninDetail generalSigninPB$BusSigninDetail) {
        this.errCode = i3;
        this.detail = generalSigninPB$BusSigninDetail;
    }

    /* renamed from: a, reason: from getter */
    public final GeneralSigninPB$BusSigninDetail getDetail() {
        return this.detail;
    }

    /* renamed from: b, reason: from getter */
    public final int getErrCode() {
        return this.errCode;
    }

    public /* synthetic */ k(int i3, GeneralSigninPB$BusSigninDetail generalSigninPB$BusSigninDetail, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, (i16 & 2) != 0 ? null : generalSigninPB$BusSigninDetail);
    }
}
