package cn2;

import android.view.View;
import com.tencent.biz.qqcircle.richframework.widget.RoundCornerImageView;
import com.tencent.biz.qui.profileskin.widget.QUITextView;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.ioc.callback.OnPromiseResolved;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.common.picload.QQPicLoader;
import com.tencent.mobileqq.richmedialist.model.BaseItemInfo;
import com.tencent.mobileqq.richmedialist.model.DirectoryItemInfo;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0007\u00a2\u0006\u0004\b$\u0010%J\b\u0010\u0005\u001a\u00020\u0004H\u0014J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014J*\u0010\u0010\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\u000b2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rH\u0014J\u0012\u0010\u0012\u001a\u00020\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0006H\u0016R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010!\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010#\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010 \u00a8\u0006&"}, d2 = {"Lcn2/d;", "Lcom/tencent/biz/richframework/part/adapter/section/Section;", "Lcom/tencent/mobileqq/richmedialist/model/DirectoryItemInfo;", "Landroid/view/View$OnClickListener;", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "", "onInitView", "data", "", "position", "", "", "payload", "r", "v", NodeProps.ON_CLICK, "", "d", "Ljava/lang/String;", "TAG", "e", "Landroid/view/View;", "itemView", "Lcom/tencent/biz/qqcircle/richframework/widget/RoundCornerImageView;", "f", "Lcom/tencent/biz/qqcircle/richframework/widget/RoundCornerImageView;", "iconView", "Lcom/tencent/biz/qui/profileskin/widget/QUITextView;", tl.h.F, "Lcom/tencent/biz/qui/profileskin/widget/QUITextView;", "nameText", "i", "descText", "<init>", "()V", "RichMediaBrowser_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class d extends Section<DirectoryItemInfo> implements View.OnClickListener {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String TAG = "DirectorySection";

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View itemView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RoundCornerImageView iconView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QUITextView nameText;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QUITextView descText;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(d this$0, DirectoryItemInfo it, LoadState loadState, Option option) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "$it");
        if (loadState.isFinishError()) {
            QLog.e(this$0.TAG, 1, "[onBindData]: load pic " + it.getIconPath() + " failed");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(View view, an2.a aVar) {
        Object tag = view.getTag();
        Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type com.tencent.mobileqq.richmedialist.model.BaseItemInfo");
        aVar.a4((BaseItemInfo) tag);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        return new int[]{R.id.f74273vt};
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable final View v3) {
        Object obj;
        EventCollector.getInstance().onViewClickedBefore(v3);
        if (v3 != null) {
            obj = v3.getTag();
        } else {
            obj = null;
        }
        if ((obj instanceof BaseItemInfo) && v3.getId() == R.id.uid) {
            RFWIocAbilityProvider.g().getIoc(an2.a.class).withGlobal(v3.getContext()).done(new OnPromiseResolved() { // from class: cn2.c
                @Override // com.tencent.biz.richframework.ioc.callback.OnPromiseResolved
                public final void onDone(Object obj2) {
                    d.t(v3, (an2.a) obj2);
                }
            }).run();
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@Nullable View containerView) {
        View view;
        RoundCornerImageView roundCornerImageView;
        QUITextView qUITextView;
        QUITextView qUITextView2 = null;
        if (containerView != null) {
            view = containerView.findViewById(R.id.uid);
        } else {
            view = null;
        }
        this.itemView = view;
        if (view != null) {
            view.setOnClickListener(this);
        }
        if (containerView != null) {
            roundCornerImageView = (RoundCornerImageView) containerView.findViewById(R.id.c_u);
        } else {
            roundCornerImageView = null;
        }
        this.iconView = roundCornerImageView;
        if (roundCornerImageView != null) {
            roundCornerImageView.setCorner(ViewUtils.dpToPx(6.0f));
        }
        if (containerView != null) {
            qUITextView = (QUITextView) containerView.findViewById(R.id.c_x);
        } else {
            qUITextView = null;
        }
        this.nameText = qUITextView;
        if (containerView != null) {
            qUITextView2 = (QUITextView) containerView.findViewById(R.id.v57);
        }
        this.descText = qUITextView2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public void onBindData(@Nullable final DirectoryItemInfo data, int position, @Nullable List<Object> payload) {
        if (data != null) {
            View view = this.itemView;
            if (view != null) {
                view.setTag(data);
            }
            if (data.getResId() != 0) {
                RoundCornerImageView roundCornerImageView = this.iconView;
                if (roundCornerImageView != null) {
                    roundCornerImageView.setImageResource(data.getResId());
                }
            } else {
                Option option = Option.obtain().setUrl(data.getIconPath()).setTargetView(this.iconView).setLoadingDrawable(getRootView().getResources().getDrawable(R.drawable.bqc)).setFailDrawable(getRootView().getResources().getDrawable(R.drawable.bqc)).setRequestWidth(ViewUtils.dpToPx(40.0f)).setRegionHeight(ViewUtils.dpToPx(40.0f));
                QQPicLoader qQPicLoader = QQPicLoader.f201806a;
                Intrinsics.checkNotNullExpressionValue(option, "option");
                qQPicLoader.e(option, new IPicLoadStateListener() { // from class: cn2.b
                    @Override // com.tencent.libra.listener.IPicLoadStateListener
                    public final void onStateChange(LoadState loadState, Option option2) {
                        d.s(d.this, data, loadState, option2);
                    }
                });
            }
            dn2.d dVar = dn2.d.f394315a;
            dVar.a(data.getFileName(), this.nameText);
            dVar.a(data.getFileTime(), this.descText);
        }
    }
}
