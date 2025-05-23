package com.tencent.mobileqq.guild.feed.widget.sort;

import android.animation.AnimatorInflater;
import android.animation.StateListAnimator;
import android.content.Context;
import android.os.Build;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedBaseInitBean;
import com.tencent.mobileqq.guild.feed.manager.GuildInfoManager;
import com.tencent.mobileqq.guild.feed.viewmodel.j;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.guild.util.IGuildFastClickUtilApi;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.vas.VasPerfReportUtils;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 12\u00020\u0001:\u00012B\u0007\u00a2\u0006\u0004\b/\u00100J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\u0004H\u0002J\b\u0010\r\u001a\u00020\u0004H\u0002J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0006H\u0002J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0006H\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0002J\u0012\u0010\u0015\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\u001a\u0010\u0016\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0017\u001a\u00020\u0004H\u0016J\u0010\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\tH\u0016J\b\u0010\u001a\u001a\u00020\u0004H\u0016R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u001cR\u0018\u0010 \u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010\"\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010!R\u0018\u0010$\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010#R\u0018\u0010'\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010&R\"\u0010+\u001a\u0010\u0012\f\u0012\n )*\u0004\u0018\u00010\u00060\u00060(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010*R\u0018\u0010.\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-\u00a8\u00063"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/widget/sort/f;", "Lcom/tencent/mobileqq/guild/feed/widget/sort/g;", "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedBaseInitBean;", "initBean", "", "i", "", "mode", "g", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "j", h.F, "d", "sortMode", DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "f", "Lcom/tencent/mobileqq/guild/feed/viewmodel/j;", "viewModel", "b2", "N7", VasPerfReportUtils.WHILE_UPDATE_ITEM, "v", NodeProps.ON_CLICK, "destroy", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "mSortTypeText", "e", "Landroid/view/View;", "mSortTypeContainer", "I", "sortType", "Lcom/tencent/mobileqq/guild/feed/viewmodel/j;", "mSortViewModel", "Landroid/content/Context;", "Landroid/content/Context;", "mContext", "Landroidx/lifecycle/Observer;", "kotlin.jvm.PlatformType", "Landroidx/lifecycle/Observer;", "observer", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedBaseInitBean;", "mInitBean", "<init>", "()V", "D", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class f implements g {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private GuildFeedBaseInitBean mInitBean;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView mSortTypeText;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View mSortTypeContainer;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private j mSortViewModel;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Context mContext;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int sortType = 1;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Observer<Integer> observer = new Observer() { // from class: com.tencent.mobileqq.guild.feed.widget.sort.c
        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object obj) {
            f.l(f.this, ((Integer) obj).intValue());
        }
    };

    private final void d() {
        com.tencent.mobileqq.guild.feed.report.d.e(this.mSortTypeContainer, "em_sgrp_forum_sort_new_type", ClickPolicy.REPORT_ALL, ExposurePolicy.REPORT_ALL, EndExposurePolicy.REPORT_NONE, new HashMap(), new IDynamicParams() { // from class: com.tencent.mobileqq.guild.feed.widget.sort.e
            @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
            public final Map getDynamicParams(String str) {
                Map e16;
                e16 = f.e(f.this, str);
                return e16;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map e(f this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        HashMap hashMap = new HashMap();
        hashMap.put("sgrp_forum_sort_new_type", Integer.valueOf(this$0.sortType));
        return hashMap;
    }

    private final boolean f() {
        return ((IGuildFastClickUtilApi) QRoute.api(IGuildFastClickUtilApi.class)).isFastClick("Guild_Feed_GuildFeedListTroopSortView");
    }

    private final void g(int mode) {
        n(mode);
    }

    private final void h() {
        View view = this.mSortTypeContainer;
        if (view != null) {
            view.setOnClickListener(this);
        }
    }

    private final void i(GuildFeedBaseInitBean initBean) {
        g(GuildInfoManager.q().x(initBean));
    }

    private final void j(View rootView) {
        this.mSortTypeContainer = rootView.findViewById(R.id.x18);
        TextView textView = (TextView) rootView.findViewById(R.id.x17);
        this.mSortTypeText = textView;
        if (textView != null) {
            textView.setTextColor(AppCompatResources.getColorStateList(rootView.getContext(), R.color.qui_common_text_primary));
        }
        ImageView imageView = (ImageView) rootView.findViewById(R.id.x19);
        if (imageView != null) {
            Context context = rootView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "rootView.context");
            imageView.setImageDrawable(GuildUIUtils.w(context, R.drawable.guild_feed_sort_icon, Integer.valueOf(R.color.qui_common_text_primary)));
        }
        if (Build.VERSION.SDK_INT >= 26) {
            StateListAnimator loadStateListAnimator = AnimatorInflater.loadStateListAnimator(rootView.getContext(), R.animator.f155134n);
            View view = this.mSortTypeContainer;
            if (view != null) {
                view.setStateListAnimator(loadStateListAnimator);
            }
        }
        h();
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.widget.sort.d
            @Override // java.lang.Runnable
            public final void run() {
                f.k(f.this);
            }
        }, 16, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(f this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(f this$0, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.g(i3);
    }

    private final void m(int sortMode) {
        if (this.mSortTypeContainer == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        if (sortMode != 1) {
            if (sortMode == 3) {
                this.sortType = 1;
            }
        } else {
            this.sortType = 2;
        }
        hashMap.put("sgrp_forum_sort_new_type", Integer.valueOf(this.sortType));
        VideoReport.reportEvent("clck", this.mSortTypeContainer, hashMap);
    }

    private final void n(int sortMode) {
        TextView textView;
        if (sortMode != 1 && sortMode != 3) {
            View view = this.mSortTypeContainer;
            if (view != null) {
                view.setVisibility(8);
                return;
            }
            return;
        }
        View view2 = this.mSortTypeContainer;
        if (view2 != null) {
            view2.setVisibility(0);
        }
        CharSequence charSequence = null;
        if (sortMode != 1) {
            if (sortMode == 3 && (textView = this.mSortTypeText) != null) {
                Context context = this.mContext;
                if (context != null) {
                    charSequence = context.getText(R.string.f145450ri);
                }
                textView.setText(charSequence);
            }
        } else {
            TextView textView2 = this.mSortTypeText;
            if (textView2 != null) {
                Context context2 = this.mContext;
                if (context2 != null) {
                    charSequence = context2.getText(R.string.f145400rd);
                }
                textView2.setText(charSequence);
            }
        }
        m(sortMode);
    }

    @Override // com.tencent.mobileqq.guild.feed.widget.sort.g
    public void N7(@NotNull View rootView, @Nullable GuildFeedBaseInitBean initBean) {
        j jVar;
        MutableLiveData<Integer> L1;
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        this.mContext = rootView.getContext();
        this.mInitBean = initBean;
        j(rootView);
        j jVar2 = this.mSortViewModel;
        if (jVar2 == null) {
            return;
        }
        if (jVar2 != null && (L1 = jVar2.L1()) != null) {
            L1.observeForever(this.observer);
        }
        if (initBean != null && (jVar = this.mSortViewModel) != null) {
            jVar.N1(initBean);
        }
        i(initBean);
    }

    @Override // com.tencent.mobileqq.guild.feed.widget.sort.g
    public void b2(@Nullable j viewModel) {
        this.mSortViewModel = viewModel;
    }

    @Override // com.tencent.mobileqq.guild.feed.widget.sort.g
    public void destroy() {
        MutableLiveData<Integer> L1;
        j jVar = this.mSortViewModel;
        if (jVar != null && (L1 = jVar.L1()) != null) {
            L1.removeObserver(this.observer);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v3) {
        j jVar;
        EventCollector.getInstance().onViewClickedBefore(v3);
        Intrinsics.checkNotNullParameter(v3, "v");
        if (f()) {
            QLog.i("Guild_Feed_GuildFeedListTroopSortView", 1, "onClick: click too fast!");
        } else if (v3.getId() == R.id.x18 && (jVar = this.mSortViewModel) != null) {
            jVar.R1();
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.mobileqq.guild.feed.widget.sort.g
    public void updateView() {
        i(this.mInitBean);
    }
}
