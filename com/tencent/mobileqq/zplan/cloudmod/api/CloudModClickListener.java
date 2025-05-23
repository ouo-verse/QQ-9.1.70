package com.tencent.mobileqq.zplan.cloudmod.api;

import android.view.View;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zootopia.utils.m;
import com.tencent.mobileqq.zootopia.view.ZootopiaDownloadButton;
import com.tencent.mobileqq.zplan.authorize.api.EnterModCheckResult;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.data.ButtonStatus;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\u0006\u0010\u000e\u001a\u00020\f\u0012\u0016\b\u0002\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000f\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&R\u0014\u0010\u000b\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\nR\u0014\u0010\u000e\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\rR\"\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/zplan/cloudmod/api/CloudModClickListener;", "Lcom/tencent/mobileqq/zootopia/view/ZootopiaDownloadButton$a;", "Landroid/view/View;", "view", "Lcom/tencent/sqshow/zootopia/data/ButtonStatus;", "type", "", "a", "b", "", "I", "modId", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "sourceCurrent", "", "", "", "c", "Ljava/util/Map;", "ueParams", "<init>", "(ILcom/tencent/mobileqq/zootopia/ZootopiaSource;Ljava/util/Map;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public abstract class CloudModClickListener implements ZootopiaDownloadButton.a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int modId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final ZootopiaSource sourceCurrent;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final Map<String, Object> ueParams;

    public CloudModClickListener(int i3, ZootopiaSource sourceCurrent, Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(sourceCurrent, "sourceCurrent");
        this.modId = i3;
        this.sourceCurrent = sourceCurrent;
        this.ueParams = map;
    }

    @Override // com.tencent.mobileqq.zootopia.view.ZootopiaDownloadButton.a
    public void a(final View view, final ButtonStatus type) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(type, "type");
        QLog.i("CloudModClickListener", 1, "onButtonClick type = " + type + ", sourceCurrent = " + this.sourceCurrent);
        if (type == ButtonStatus.INIT && !m.f329564a.c()) {
            ((a) vb3.a.f441346a.a(a.class)).T(this.modId, true, this.sourceCurrent, this.ueParams, new Function1<EnterModCheckResult, Unit>() { // from class: com.tencent.mobileqq.zplan.cloudmod.api.CloudModClickListener$onButtonClick$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(EnterModCheckResult enterModCheckResult) {
                    invoke2(enterModCheckResult);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(EnterModCheckResult it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    if (it.isPassed()) {
                        return;
                    }
                    CloudModClickListener.this.b(view, type);
                }
            });
        } else {
            b(view, type);
        }
    }

    public abstract void b(View view, ButtonStatus type);

    public /* synthetic */ CloudModClickListener(int i3, ZootopiaSource zootopiaSource, Map map, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, zootopiaSource, (i16 & 4) != 0 ? null : map);
    }
}
