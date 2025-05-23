package com.tencent.mobileqq.wink.templatelibrary.memoryalbum;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.richframework.part.ImmersivePartFragment;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qui.QUIImmersiveHelper;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 *2\u00020\u0001:\u0001+B\u0007\u00a2\u0006\u0004\b(\u0010)J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\bH\u0002J\b\u0010\f\u001a\u00020\u000bH\u0014J\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016J\b\u0010\u0010\u001a\u00020\u0004H\u0014J\u001a\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0016\u001a\u00020\bH\u0016J\b\u0010\u0017\u001a\u00020\u000bH\u0014R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001d\u001a\u00020\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001aR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010'\u001a\u00020\u001e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b&\u0010 \u00a8\u0006,"}, d2 = {"Lcom/tencent/mobileqq/wink/templatelibrary/memoryalbum/MemoryAlbumSettingFragment;", "Lcom/tencent/biz/richframework/part/ImmersivePartFragment;", "Landroid/widget/CompoundButton;", "compoundButton", "", "isChecked", "", "elementId", "", "th", "yh", "", "getContentLayoutId", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "isUseDarkTextStatusBar", "Landroid/view/View;", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onResume", "getStatusBarColor", "Lcom/tencent/mobileqq/widget/FormSwitchItem;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/widget/FormSwitchItem;", "authorizeSwitchItem", "D", "messagePushSwitchItem", "Landroid/widget/TextView;", "E", "Landroid/widget/TextView;", "hint", "Landroid/widget/ImageView;", UserInfo.SEX_FEMALE, "Landroid/widget/ImageView;", "close", "G", "title", "<init>", "()V", "I", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class MemoryAlbumSettingFragment extends ImmersivePartFragment {

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    private FormSwitchItem authorizeSwitchItem;

    /* renamed from: D, reason: from kotlin metadata */
    private FormSwitchItem messagePushSwitchItem;

    /* renamed from: E, reason: from kotlin metadata */
    private TextView hint;

    /* renamed from: F, reason: from kotlin metadata */
    private ImageView close;

    /* renamed from: G, reason: from kotlin metadata */
    private TextView title;

    @NotNull
    public Map<Integer, View> H = new LinkedHashMap();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/wink/templatelibrary/memoryalbum/MemoryAlbumSettingFragment$a;", "", "Lcom/tencent/mobileqq/wink/templatelibrary/memoryalbum/MemoryAlbumSettingFragment;", "a", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.templatelibrary.memoryalbum.MemoryAlbumSettingFragment$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final MemoryAlbumSettingFragment a() {
            return new MemoryAlbumSettingFragment();
        }

        Companion() {
        }
    }

    private final void th(CompoundButton compoundButton, boolean isChecked, String elementId) {
        String str;
        VideoReport.setElementId(compoundButton, elementId);
        Map<String, Object> reportMap = WinkDTParamBuilder.buildElementParams();
        Intrinsics.checkNotNullExpressionValue(reportMap, "reportMap");
        if (!isChecked) {
            str = "open";
        } else {
            str = "close";
        }
        reportMap.put("xsj_status", str);
        VideoReport.setElementClickPolicy(compoundButton, ClickPolicy.REPORT_NONE);
        VideoReport.setElementExposePolicy(compoundButton, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementEndExposePolicy(compoundButton, EndExposurePolicy.REPORT_NONE);
        VideoReport.reportEvent("dt_clck", compoundButton, reportMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void uh(MemoryAlbumSettingFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getParentFragmentManager().popBackStackImmediate();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void vh(MemoryAlbumSettingFragment this$0, CompoundButton it, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(it, z16);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.th(it, z16, WinkDaTongReportConstant.ElementId.EM_XSJ_MEMORIES_ALBUM_PUSHMSG_BUTTON);
        v83.e eVar = v83.e.f441245a;
        if (eVar.f()) {
            eVar.d(z16);
        }
        EventCollector.getInstance().onCompoundButtonChecked(it, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void wh(MemoryAlbumSettingFragment this$0, CompoundButton it, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(it, z16);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.th(it, z16, WinkDaTongReportConstant.ElementId.EM_XSJ_MEMORIES_ALBUM_SETTING_BUTTON);
        v83.e eVar = v83.e.f441245a;
        eVar.m(z16);
        FormSwitchItem formSwitchItem = null;
        if (!z16) {
            FormSwitchItem formSwitchItem2 = this$0.messagePushSwitchItem;
            if (formSwitchItem2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("messagePushSwitchItem");
                formSwitchItem2 = null;
            }
            formSwitchItem2.setEnabled(false);
            FormSwitchItem formSwitchItem3 = this$0.messagePushSwitchItem;
            if (formSwitchItem3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("messagePushSwitchItem");
            } else {
                formSwitchItem = formSwitchItem3;
            }
            formSwitchItem.setChecked(false);
        } else {
            FormSwitchItem formSwitchItem4 = this$0.messagePushSwitchItem;
            if (formSwitchItem4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("messagePushSwitchItem");
                formSwitchItem4 = null;
            }
            formSwitchItem4.setEnabled(true);
            FormSwitchItem formSwitchItem5 = this$0.messagePushSwitchItem;
            if (formSwitchItem5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("messagePushSwitchItem");
            } else {
                formSwitchItem = formSwitchItem5;
            }
            formSwitchItem.setChecked(eVar.h());
        }
        EventCollector.getInstance().onCompoundButtonChecked(it, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void xh(MemoryAlbumSettingFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QUIImmersiveHelper.u(this$0.requireActivity().getWindow(), true, true);
    }

    private final void yh() {
        VideoReport.addToDetectionWhitelist(getActivity());
        VideoReport.setPageId(getFragmentContentView(), WinkDaTongReportConstant.PageId.PG_XSJ_MEMORIES_COLLECTION_SETTING_PAGE);
        VideoReport.setPageParams(getFragmentContentView(), new WinkDTParamBuilder().buildPageParams(null, WinkContext.INSTANCE.d().getDtParams().c()));
    }

    public void _$_clearFindViewByIdCache() {
        this.H.clear();
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    public List<Part> assembleParts() {
        return new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.i6z;
    }

    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment
    protected int getStatusBarColor() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment
    public boolean isUseDarkTextStatusBar() {
        if (!uq3.c.P6()) {
            return true;
        }
        return !QQTheme.isNowThemeIsNight();
    }

    @Override // androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        yh();
    }

    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        View findViewById = view.findViewById(R.id.z2v);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.memory_album_close)");
        this.close = (ImageView) findViewById;
        ((ImageView) view.findViewById(R.id.f166233z34)).setVisibility(8);
        ImageView imageView = this.close;
        ImageView imageView2 = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("close");
            imageView = null;
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.templatelibrary.memoryalbum.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                MemoryAlbumSettingFragment.uh(MemoryAlbumSettingFragment.this, view2);
            }
        });
        View findViewById2 = view.findViewById(R.id.jq_);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.title_tv)");
        TextView textView = (TextView) findViewById2;
        this.title = textView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("title");
            textView = null;
        }
        textView.setText(view.getContext().getText(R.string.fsy));
        View findViewById3 = view.findViewById(R.id.z5k);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.message_push_swith_item)");
        FormSwitchItem formSwitchItem = (FormSwitchItem) findViewById3;
        this.messagePushSwitchItem = formSwitchItem;
        if (formSwitchItem == null) {
            Intrinsics.throwUninitializedPropertyAccessException("messagePushSwitchItem");
            formSwitchItem = null;
        }
        FormSwitchItem formSwitchItem2 = this.messagePushSwitchItem;
        if (formSwitchItem2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("messagePushSwitchItem");
            formSwitchItem2 = null;
        }
        formSwitchItem.setText(formSwitchItem2.getContext().getText(R.string.f239957nv));
        FormSwitchItem formSwitchItem3 = this.messagePushSwitchItem;
        if (formSwitchItem3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("messagePushSwitchItem");
            formSwitchItem3 = null;
        }
        formSwitchItem3.setTextColor(ColorStateList.valueOf(ie0.a.f().g(getContext(), R.color.qui_common_text_primary, 1000)));
        FormSwitchItem formSwitchItem4 = this.messagePushSwitchItem;
        if (formSwitchItem4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("messagePushSwitchItem");
            formSwitchItem4 = null;
        }
        v83.e eVar = v83.e.f441245a;
        formSwitchItem4.setChecked(eVar.h());
        FormSwitchItem formSwitchItem5 = this.messagePushSwitchItem;
        if (formSwitchItem5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("messagePushSwitchItem");
            formSwitchItem5 = null;
        }
        formSwitchItem5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.wink.templatelibrary.memoryalbum.i
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                MemoryAlbumSettingFragment.vh(MemoryAlbumSettingFragment.this, compoundButton, z16);
            }
        });
        View findViewById4 = view.findViewById(R.id.szi);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.authorize_swith_item)");
        FormSwitchItem formSwitchItem6 = (FormSwitchItem) findViewById4;
        this.authorizeSwitchItem = formSwitchItem6;
        if (formSwitchItem6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("authorizeSwitchItem");
            formSwitchItem6 = null;
        }
        FormSwitchItem formSwitchItem7 = this.authorizeSwitchItem;
        if (formSwitchItem7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("authorizeSwitchItem");
            formSwitchItem7 = null;
        }
        formSwitchItem6.setText(formSwitchItem7.getContext().getText(R.string.f240227ol));
        FormSwitchItem formSwitchItem8 = this.authorizeSwitchItem;
        if (formSwitchItem8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("authorizeSwitchItem");
            formSwitchItem8 = null;
        }
        formSwitchItem8.setTextColor(ColorStateList.valueOf(ie0.a.f().g(getContext(), R.color.qui_common_text_primary, 1000)));
        FormSwitchItem formSwitchItem9 = this.authorizeSwitchItem;
        if (formSwitchItem9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("authorizeSwitchItem");
            formSwitchItem9 = null;
        }
        formSwitchItem9.setChecked(eVar.f());
        FormSwitchItem formSwitchItem10 = this.authorizeSwitchItem;
        if (formSwitchItem10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("authorizeSwitchItem");
            formSwitchItem10 = null;
        }
        formSwitchItem10.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.wink.templatelibrary.memoryalbum.j
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                MemoryAlbumSettingFragment.wh(MemoryAlbumSettingFragment.this, compoundButton, z16);
            }
        });
        View findViewById5 = view.findViewById(R.id.kbk);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "view.findViewById(R.id.tv_text)");
        TextView textView2 = (TextView) findViewById5;
        this.hint = textView2;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("hint");
            textView2 = null;
        }
        TextView textView3 = this.hint;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("hint");
            textView3 = null;
        }
        textView2.setText(textView3.getContext().getText(R.string.f240217ok));
        ((ConstraintLayout) view.findViewById(R.id.f124287iy)).setBackgroundResource(R.drawable.qui_common_bg_bottom_light_bg);
        TextView textView4 = this.title;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("title");
            textView4 = null;
        }
        textView4.setTextColor(ColorStateList.valueOf(ie0.a.f().g(getContext(), R.color.qui_common_text_primary, 1000)));
        ImageView imageView3 = this.close;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("close");
        } else {
            imageView2 = imageView3;
        }
        imageView2.setImageResource(R.drawable.qui_chevron_left);
        view.post(new Runnable() { // from class: com.tencent.mobileqq.wink.templatelibrary.memoryalbum.k
            @Override // java.lang.Runnable
            public final void run() {
                MemoryAlbumSettingFragment.xh(MemoryAlbumSettingFragment.this);
            }
        });
    }
}
