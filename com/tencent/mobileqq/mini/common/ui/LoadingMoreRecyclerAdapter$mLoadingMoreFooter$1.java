package com.tencent.mobileqq.mini.common.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public /* synthetic */ class LoadingMoreRecyclerAdapter$mLoadingMoreFooter$1 extends FunctionReferenceImpl implements Function2<LayoutInflater, ViewGroup, View> {
    @Override // kotlin.jvm.functions.Function2
    public final View invoke(LayoutInflater p06, ViewGroup p16) {
        Intrinsics.checkNotNullParameter(p06, "p0");
        Intrinsics.checkNotNullParameter(p16, "p1");
        return ((LoadingMoreRecyclerAdapter) this.receiver).createLoadingMoreFooterView(p06, p16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LoadingMoreRecyclerAdapter$mLoadingMoreFooter$1(Object obj) {
        super(2, obj, LoadingMoreRecyclerAdapter.class, "createLoadingMoreFooterView", "createLoadingMoreFooterView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;)Landroid/view/View;", 0);
    }
}
