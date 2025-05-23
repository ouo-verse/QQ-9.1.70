package com.tencent.mobileqq.selectfriend.relationlist.vm;

import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.selectfriend.relationlist.SharedNode;
import com.tencent.mobileqq.selectfriend.relationlist.d;
import com.tencent.mobileqq.selectfriend.relationlist.e;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u0012\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J,\u0010\r\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00062\u001a\u0010\f\u001a\u0016\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\n\u0012\u0004\u0012\u00020\u000b0\tH\u0016J,\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00062\u001a\u0010\f\u001a\u0016\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\n\u0012\u0004\u0012\u00020\u000b0\tH\u0016J\u001a\u0010\u0011\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0010\u001a\u00020\u0006H\u0016R\u0014\u0010\u0014\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/selectfriend/relationlist/vm/a;", "Lcom/tencent/mobileqq/selectfriend/relationlist/vm/b;", "Lcom/tencent/mobileqq/selectfriend/relationlist/SharedNode;", "sharedNode", "Landroid/graphics/drawable/Drawable;", "a", "", "d", "fromNet", "Lkotlin/Function1;", "", "", "callback", "c", "Lcom/tencent/mobileqq/selectfriend/relationlist/d;", "b", "isMultiSelect", "e", "Lcom/tencent/mobileqq/selectfriend/relationlist/model/a;", "Lcom/tencent/mobileqq/selectfriend/relationlist/model/a;", "dataModel", "<init>", "(Lcom/tencent/mobileqq/selectfriend/relationlist/model/a;)V", "qq_selectfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class a extends b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final com.tencent.mobileqq.selectfriend.relationlist.model.a dataModel;

    public a(com.tencent.mobileqq.selectfriend.relationlist.model.a dataModel) {
        Intrinsics.checkNotNullParameter(dataModel, "dataModel");
        this.dataModel = dataModel;
    }

    @Override // com.tencent.mobileqq.selectfriend.relationlist.vm.b
    public Drawable a(SharedNode sharedNode) {
        Intrinsics.checkNotNullParameter(sharedNode, "sharedNode");
        return this.dataModel.a(sharedNode);
    }

    @Override // com.tencent.mobileqq.selectfriend.relationlist.vm.b
    public void b(boolean fromNet, Function1<? super List<d>, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.dataModel.c(fromNet, callback);
    }

    @Override // com.tencent.mobileqq.selectfriend.relationlist.vm.b
    public void c(boolean fromNet, Function1<? super List<SharedNode>, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.dataModel.d(fromNet, callback);
    }

    @Override // com.tencent.mobileqq.selectfriend.relationlist.vm.b
    public boolean d(SharedNode sharedNode) {
        if (sharedNode == null) {
            return false;
        }
        return e.f285562a.g(sharedNode);
    }

    @Override // com.tencent.mobileqq.selectfriend.relationlist.vm.b
    public void e(SharedNode sharedNode, boolean isMultiSelect) {
        if (sharedNode == null) {
            return;
        }
        if (isMultiSelect) {
            e.f285562a.c(sharedNode);
        } else {
            e.f285562a.j(sharedNode);
        }
    }
}
