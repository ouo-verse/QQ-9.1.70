package com.tencent.qqnt.ntrelation.vasinfo.api.impl;

import com.tencent.qqnt.ntrelation.friendsinfo.bean.e;
import com.tencent.qqnt.ntrelation.vasinfo.api.IQQVasDataCallbackService;
import hx3.b;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kx3.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0001\u0012B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016J8\u0010\u000e\u001a\u00020\u00052\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\fH\u0016\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/qqnt/ntrelation/vasinfo/api/impl/QQVasDataCallbackServiceImpl;", "Lcom/tencent/qqnt/ntrelation/vasinfo/api/IQQVasDataCallbackService;", "Lcom/tencent/qqnt/ntrelation/friendsinfo/bean/e;", "Lkx3/a;", "data", "", "vasInfoToCallback", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "uids", "trace", "Lhx3/b;", "iQueryGeneralDataCallback", "registerVasInfoCallback", "<init>", "()V", "Companion", "a", "contacts_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class QQVasDataCallbackServiceImpl implements IQQVasDataCallbackService {

    @NotNull
    public static final String TAG = "QQVasDataCallbackServiceImpl";

    @Override // com.tencent.qqnt.ntrelation.vasinfo.api.IQQVasDataCallbackService
    public void registerVasInfoCallback(@NotNull ArrayList<String> uids, @Nullable String trace, @NotNull b<a> iQueryGeneralDataCallback) {
        Intrinsics.checkNotNullParameter(uids, "uids");
        Intrinsics.checkNotNullParameter(iQueryGeneralDataCallback, "iQueryGeneralDataCallback");
    }

    @Override // com.tencent.qqnt.ntrelation.vasinfo.api.IQQVasDataCallbackService
    public void vasInfoToCallback(@Nullable e<a> data) {
        lx3.a.f415742a.c(data);
    }
}
