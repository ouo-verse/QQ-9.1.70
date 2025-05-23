package com.tencent.sqshow.zootopia.samestyle.mix.helper;

import android.content.Context;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.sqshow.zootopia.samestyle.TemplatePreviewViewModel;
import com.tencent.sqshow.zootopia.samestyle.ZPlanTemplate;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import n74.dh;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b \u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\u0006\u0010\u0018\u001a\u00020\u0014\u0012\u0006\u0010\u001d\u001a\u00020\u0019\u0012\u0006\u0010!\u001a\u00020\u001e\u0012\u0006\u0010&\u001a\u00020\"\u0012\u0006\u0010+\u001a\u00020'\u00a2\u0006\u0004\b,\u0010-J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0002H\u0016R\u001a\u0010\r\u001a\u00020\b8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0013\u001a\u00020\u000e8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0018\u001a\u00020\u00148\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u001d\u001a\u00020\u00198\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b\u0016\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010!\u001a\u00020\u001e8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b\u0007\u0010\u001f\u001a\u0004\b\t\u0010 R\u001a\u0010&\u001a\u00020\"8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b\u0005\u0010#\u001a\u0004\b$\u0010%R\u001a\u0010+\u001a\u00020'8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b\u000f\u0010*\u00a8\u0006."}, d2 = {"Lcom/tencent/sqshow/zootopia/samestyle/mix/helper/d;", "", "", "l", "k", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "j", "i", "Lcom/tencent/sqshow/zootopia/samestyle/ZPlanTemplate;", "d", "Lcom/tencent/sqshow/zootopia/samestyle/ZPlanTemplate;", "f", "()Lcom/tencent/sqshow/zootopia/samestyle/ZPlanTemplate;", "mTemplate", "Ln74/dh;", "e", "Ln74/dh;", "b", "()Ln74/dh;", "mBinding", "Lcom/tencent/sqshow/zootopia/samestyle/TemplatePreviewViewModel;", "Lcom/tencent/sqshow/zootopia/samestyle/TemplatePreviewViewModel;", tl.h.F, "()Lcom/tencent/sqshow/zootopia/samestyle/TemplatePreviewViewModel;", "mViewModel", "Landroid/content/Context;", "Landroid/content/Context;", "c", "()Landroid/content/Context;", "mContext", "Lid3/d;", "Lid3/d;", "()Lid3/d;", "mReporter", "Landroidx/lifecycle/LifecycleOwner;", "Landroidx/lifecycle/LifecycleOwner;", "g", "()Landroidx/lifecycle/LifecycleOwner;", "mViewLifecycleOwner", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "()Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "mSource", "<init>", "(Lcom/tencent/sqshow/zootopia/samestyle/ZPlanTemplate;Ln74/dh;Lcom/tencent/sqshow/zootopia/samestyle/TemplatePreviewViewModel;Landroid/content/Context;Lid3/d;Landroidx/lifecycle/LifecycleOwner;Lcom/tencent/mobileqq/zootopia/ZootopiaSource;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public abstract class d {

    /* renamed from: C, reason: from kotlin metadata */
    private final ZootopiaSource mSource;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final ZPlanTemplate mTemplate;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final dh mBinding;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final TemplatePreviewViewModel mViewModel;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final Context mContext;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final id3.d mReporter;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final LifecycleOwner mViewLifecycleOwner;

    public d(ZPlanTemplate mTemplate, dh mBinding, TemplatePreviewViewModel mViewModel, Context mContext, id3.d mReporter, LifecycleOwner mViewLifecycleOwner, ZootopiaSource mSource) {
        Intrinsics.checkNotNullParameter(mTemplate, "mTemplate");
        Intrinsics.checkNotNullParameter(mBinding, "mBinding");
        Intrinsics.checkNotNullParameter(mViewModel, "mViewModel");
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        Intrinsics.checkNotNullParameter(mReporter, "mReporter");
        Intrinsics.checkNotNullParameter(mViewLifecycleOwner, "mViewLifecycleOwner");
        Intrinsics.checkNotNullParameter(mSource, "mSource");
        this.mTemplate = mTemplate;
        this.mBinding = mBinding;
        this.mViewModel = mViewModel;
        this.mContext = mContext;
        this.mReporter = mReporter;
        this.mViewLifecycleOwner = mViewLifecycleOwner;
        this.mSource = mSource;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b, reason: from getter */
    public final dh getMBinding() {
        return this.mBinding;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: c, reason: from getter */
    public final Context getMContext() {
        return this.mContext;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: d, reason: from getter */
    public final id3.d getMReporter() {
        return this.mReporter;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: e, reason: from getter */
    public final ZootopiaSource getMSource() {
        return this.mSource;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: f, reason: from getter */
    public final ZPlanTemplate getMTemplate() {
        return this.mTemplate;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: g, reason: from getter */
    public final LifecycleOwner getMViewLifecycleOwner() {
        return this.mViewLifecycleOwner;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: h, reason: from getter */
    public final TemplatePreviewViewModel getMViewModel() {
        return this.mViewModel;
    }

    public void i() {
    }

    public void j() {
    }

    public void k() {
    }

    public void l() {
    }

    public void m() {
    }
}
