package com.tencent.sqshow.zootopia.publish.page;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.zootopia.FragmentSource;
import com.tencent.mobileqq.zootopia.Source;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.qqmini.sdk.request.GetAdInfoRequest;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u0006\u0010\b\u001a\u00020\u0007J\b\u0010\n\u001a\u00020\tH\u0016J&\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016R\u001b\u0010\u0018\u001a\u00020\u00138DX\u0084\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001b\u0010\u001b\u001a\u00020\u00138DX\u0084\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0019\u0010\u0015\u001a\u0004\b\u001a\u0010\u0017\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/sqshow/zootopia/publish/page/BaseSelectContentPage;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "Lcom/tencent/sqshow/zootopia/publish/page/a;", "Lcom/tencent/mobileqq/zootopia/FragmentSource;", "sh", "Lcom/tencent/mobileqq/zootopia/Source;", "rh", "", "getSubSource", "Landroidx/fragment/app/Fragment;", "getFragment", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", "uh", "()Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", GetAdInfoRequest.SOURCE_FROM, "D", "th", "sourceCurrent", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public abstract class BaseSelectContentPage extends QPublicBaseFragment implements a {

    /* renamed from: C, reason: from kotlin metadata */
    private final Lazy sourceFrom;

    /* renamed from: D, reason: from kotlin metadata */
    private final Lazy sourceCurrent;

    public BaseSelectContentPage() {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ZootopiaSource>() { // from class: com.tencent.sqshow.zootopia.publish.page.BaseSelectContentPage$sourceFrom$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ZootopiaSource invoke() {
                FragmentSource sh5;
                ZootopiaSource from;
                sh5 = BaseSelectContentPage.this.sh();
                return (sh5 == null || (from = sh5.getFrom()) == null) ? ZootopiaSource.INSTANCE.i() : from;
            }
        });
        this.sourceFrom = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<ZootopiaSource>() { // from class: com.tencent.sqshow.zootopia.publish.page.BaseSelectContentPage$sourceCurrent$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ZootopiaSource invoke() {
                Source rh5;
                ZootopiaSource.Companion companion = ZootopiaSource.INSTANCE;
                rh5 = BaseSelectContentPage.this.rh();
                return companion.c(rh5, BaseSelectContentPage.this.getSubSource(), BaseSelectContentPage.this.uh());
            }
        });
        this.sourceCurrent = lazy2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Source rh() {
        Source current;
        FragmentSource sh5 = sh();
        return (sh5 == null || (current = sh5.getCurrent()) == null) ? Source.UnSet : current;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FragmentSource sh() {
        Intent intent;
        ZootopiaSource.Companion companion = ZootopiaSource.INSTANCE;
        FragmentSource f16 = companion.f(getArguments());
        if (f16 != null) {
            return f16;
        }
        FragmentActivity activity = getActivity();
        return companion.f((activity == null || (intent = activity.getIntent()) == null) ? null : intent.getExtras());
    }

    public final String getSubSource() {
        return "BaseSelectContentPage";
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        TextView textView = new TextView(getContext());
        textView.setTextSize(1, 22.0f);
        textView.setGravity(17);
        textView.setText(getType().getPageName());
        return textView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final ZootopiaSource th() {
        return (ZootopiaSource) this.sourceCurrent.getValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final ZootopiaSource uh() {
        return (ZootopiaSource) this.sourceFrom.getValue();
    }

    @Override // vc4.h
    public Fragment getFragment() {
        return this;
    }
}
