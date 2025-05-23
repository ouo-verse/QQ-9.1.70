package com.tencent.mobileqq.guild.client.selectaccount;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.gdtad.jsbridge.GdtGetUserInfoHandler;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.client.GuildClientParams;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.dc;
import com.tencent.mobileqq.qqguildsdk.data.dd;
import com.tencent.mobileqq.qqguildsdk.data.ej;
import com.tencent.mobileqq.vas.api.RemoteProxy;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vh2.bf;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0018\u0018\u0000 _2\u00020\u0001:\u0001`B%\u0012\u0006\u0010.\u001a\u00020\u0019\u0012\u0006\u00102\u001a\u00020/\u0012\f\u00106\u001a\b\u0012\u0004\u0012\u0002030\u001e\u00a2\u0006\u0004\b]\u0010^J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0018\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0018\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0007H\u0002J@\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u00142\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001b\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u001a\u0010\u001d\u001a\u00020\u00022\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0016\u0010\u001f\u001a\u00020\u00022\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u001eH\u0002J\b\u0010 \u001a\u00020\u0002H\u0002J$\u0010(\u001a\u00020'2\u0006\u0010\"\u001a\u00020!2\b\u0010$\u001a\u0004\u0018\u00010#2\b\u0010&\u001a\u0004\u0018\u00010%H\u0016J\u0012\u0010*\u001a\u00020)2\b\u0010&\u001a\u0004\u0018\u00010%H\u0016J\b\u0010+\u001a\u00020\u0002H\u0016R\u0014\u0010.\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0014\u00102\u001a\u00020/8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u00101R\u001a\u00106\u001a\b\u0012\u0004\u0012\u0002030\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0016\u00109\u001a\u00020'8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b7\u00108R#\u0010@\u001a\n ;*\u0004\u0018\u00010:0:8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?R#\u0010C\u001a\n ;*\u0004\u0018\u00010:0:8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bA\u0010=\u001a\u0004\bB\u0010?R#\u0010H\u001a\n ;*\u0004\u0018\u00010D0D8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bE\u0010=\u001a\u0004\bF\u0010GR#\u0010M\u001a\n ;*\u0004\u0018\u00010I0I8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bJ\u0010=\u001a\u0004\bK\u0010LR#\u0010Q\u001a\n ;*\u0004\u0018\u00010#0#8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bN\u0010=\u001a\u0004\bO\u0010PR#\u0010T\u001a\n ;*\u0004\u0018\u00010#0#8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bR\u0010=\u001a\u0004\bS\u0010PR\u001c\u0010V\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bU\u00105R\u001a\u0010X\u001a\b\u0012\u0004\u0012\u00020:0\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bW\u00105R\u001c\u0010Z\u001a\b\u0012\u0004\u0012\u00020\u00170\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bY\u00105R\u0016\u0010\\\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b[\u0010E\u00a8\u0006a"}, d2 = {"Lcom/tencent/mobileqq/guild/client/selectaccount/GuildClientSelectZoneDialogFragment;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "", "initData", "initView", "Qh", "Sh", "Lcom/tencent/mobileqq/guild/client/selectaccount/p;", "info", "Ph", "", "index", "Jh", OcrConfig.CHINESE, "Lcom/tencent/mobileqq/guild/client/selectaccount/GuildClientSelectListDialogFragment;", "fragment", "Uh", GdtGetUserInfoHandler.KEY_AREA, "Nh", "result", "", "nextIsRole", "", "Lcom/tencent/mobileqq/qqguildsdk/data/ej;", "roleList", "Lcom/tencent/mobileqq/qqguildsdk/data/dd;", "areaList", RemoteProxy.KEY_RESULT_TYPE, "Lh", "Kh", "", "Mh", "Wh", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "Landroid/app/Dialog;", "onCreateDialog", "onStart", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/qqguildsdk/data/dd;", "area0List", "Lcom/tencent/mobileqq/guild/client/GuildClientParams;", "D", "Lcom/tencent/mobileqq/guild/client/GuildClientParams;", "mParams", "Lcom/tencent/mobileqq/qqguildsdk/data/dc;", "E", "Ljava/util/List;", "mAreaLevelList", UserInfo.SEX_FEMALE, "Landroid/view/View;", "mRootView", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "G", "Lkotlin/Lazy;", "Fh", "()Landroid/widget/TextView;", "mTitleTv", "H", "Dh", "mRoleTv", "Landroid/widget/Button;", "I", "Eh", "()Landroid/widget/Button;", "mSubmitBtn", "Landroid/widget/ImageView;", "J", "Bh", "()Landroid/widget/ImageView;", "mRoleArrow", "K", "Ah", "()Landroid/view/ViewGroup;", "mItemContainer", "L", "Ch", "mRoleItem", "M", "mDataList", "N", "mItemTextList", "P", "mRoleList", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "mCurrentSelectIndex", "<init>", "(Lcom/tencent/mobileqq/qqguildsdk/data/dd;Lcom/tencent/mobileqq/guild/client/GuildClientParams;Ljava/util/List;)V", BdhLogUtil.LogTag.Tag_Req, "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class GuildClientSelectZoneDialogFragment extends BottomSheetDialogFragment {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final dd area0List;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final GuildClientParams mParams;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final List<dc> mAreaLevelList;

    /* renamed from: F, reason: from kotlin metadata */
    private View mRootView;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final Lazy mTitleTv;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final Lazy mRoleTv;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final Lazy mSubmitBtn;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final Lazy mRoleArrow;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final Lazy mItemContainer;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final Lazy mRoleItem;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final List<dd> mDataList;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final List<TextView> mItemTextList;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private List<? extends ej> mRoleList;

    /* renamed from: Q, reason: from kotlin metadata */
    private int mCurrentSelectIndex;

    /* JADX WARN: Multi-variable type inference failed */
    public GuildClientSelectZoneDialogFragment(@NotNull dd area0List, @NotNull GuildClientParams mParams, @NotNull List<? extends dc> mAreaLevelList) {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        Lazy lazy6;
        List<? extends ej> emptyList;
        Intrinsics.checkNotNullParameter(area0List, "area0List");
        Intrinsics.checkNotNullParameter(mParams, "mParams");
        Intrinsics.checkNotNullParameter(mAreaLevelList, "mAreaLevelList");
        this.area0List = area0List;
        this.mParams = mParams;
        this.mAreaLevelList = mAreaLevelList;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: com.tencent.mobileqq.guild.client.selectaccount.GuildClientSelectZoneDialogFragment$mTitleTv$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                View view;
                view = GuildClientSelectZoneDialogFragment.this.mRootView;
                if (view == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mRootView");
                    view = null;
                }
                return (TextView) view.findViewById(R.id.title);
            }
        });
        this.mTitleTv = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: com.tencent.mobileqq.guild.client.selectaccount.GuildClientSelectZoneDialogFragment$mRoleTv$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                View view;
                view = GuildClientSelectZoneDialogFragment.this.mRootView;
                if (view == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mRootView");
                    view = null;
                }
                return (TextView) view.findViewById(R.id.f779345p);
            }
        });
        this.mRoleTv = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<Button>() { // from class: com.tencent.mobileqq.guild.client.selectaccount.GuildClientSelectZoneDialogFragment$mSubmitBtn$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Button invoke() {
                View view;
                view = GuildClientSelectZoneDialogFragment.this.mRootView;
                if (view == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mRootView");
                    view = null;
                }
                return (Button) view.findViewById(R.id.j6n);
            }
        });
        this.mSubmitBtn = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>() { // from class: com.tencent.mobileqq.guild.client.selectaccount.GuildClientSelectZoneDialogFragment$mRoleArrow$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ImageView invoke() {
                View view;
                view = GuildClientSelectZoneDialogFragment.this.mRootView;
                if (view == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mRootView");
                    view = null;
                }
                return (ImageView) view.findViewById(R.id.f74513wg);
            }
        });
        this.mRoleArrow = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(new Function0<ViewGroup>() { // from class: com.tencent.mobileqq.guild.client.selectaccount.GuildClientSelectZoneDialogFragment$mItemContainer$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewGroup invoke() {
                View view;
                view = GuildClientSelectZoneDialogFragment.this.mRootView;
                if (view == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mRootView");
                    view = null;
                }
                return (ViewGroup) view.findViewById(R.id.dpq);
            }
        });
        this.mItemContainer = lazy5;
        lazy6 = LazyKt__LazyJVMKt.lazy(new Function0<ViewGroup>() { // from class: com.tencent.mobileqq.guild.client.selectaccount.GuildClientSelectZoneDialogFragment$mRoleItem$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewGroup invoke() {
                View view;
                view = GuildClientSelectZoneDialogFragment.this.mRootView;
                if (view == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mRootView");
                    view = null;
                }
                return (ViewGroup) view.findViewById(R.id.f776044t);
            }
        });
        this.mRoleItem = lazy6;
        this.mDataList = new ArrayList();
        this.mItemTextList = new ArrayList();
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.mRoleList = emptyList;
    }

    private final ViewGroup Ah() {
        return (ViewGroup) this.mItemContainer.getValue();
    }

    private final ImageView Bh() {
        return (ImageView) this.mRoleArrow.getValue();
    }

    private final ViewGroup Ch() {
        return (ViewGroup) this.mRoleItem.getValue();
    }

    private final TextView Dh() {
        return (TextView) this.mRoleTv.getValue();
    }

    private final Button Eh() {
        return (Button) this.mSubmitBtn.getValue();
    }

    private final TextView Fh() {
        return (TextView) this.mTitleTv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Gh(GuildClientSelectZoneDialogFragment this$0, int i3, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Jh(i3);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Hh(GuildClientSelectZoneDialogFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Qh();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ih(GuildClientSelectZoneDialogFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Sh();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void Jh(int index) {
        if (index > this.mCurrentSelectIndex) {
            Wh();
            return;
        }
        if (this.mDataList.get(index) != null && this.mItemTextList.get(index).getTag() != null) {
            String desc = this.mAreaLevelList.get(index).getDesc();
            Intrinsics.checkNotNullExpressionValue(desc, "mAreaLevelList[index].desc");
            String z16 = this.mParams.z();
            Intrinsics.checkNotNullExpressionValue(z16, "mParams.clientId");
            Object tag = this.mItemTextList.get(index).getTag();
            Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type kotlin.String");
            Uh(index, new GuildClientSelectAreaListDialogFragment(desc, z16, (String) tag));
        }
    }

    private final void Kh(dd areaList, int index) {
        if (areaList != null) {
            int i3 = index + 1;
            this.mDataList.set(i3, areaList);
            this.mCurrentSelectIndex = i3;
        } else {
            Context applicationContext = MobileQQ.sMobileQQ.getApplicationContext();
            String string = getResources().getString(R.string.f155741ib);
            Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st\u2026uild_select_zone_no_area)");
            String format = String.format(string, Arrays.copyOf(new Object[]{this.mAreaLevelList.get(index + 1).getDesc()}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
            QQToast.makeText(applicationContext, format, 0).show();
        }
    }

    private final void Lh(int result, boolean nextIsRole, List<ej> roleList, dd areaList, int resultType, int index) {
        com.tencent.mobileqq.guild.safety.j.d("GuildClientSelectZoneDialogFragment", "onGetResult | result: " + result + " | resultType: " + resultType);
        if (result == 0 && (resultType == 2 || resultType == 1)) {
            if (nextIsRole) {
                Mh(roleList);
                return;
            } else {
                Kh(areaList, index);
                return;
            }
        }
        QQToast.makeText(MobileQQ.sMobileQQ.getApplicationContext(), getResources().getString(R.string.f155711i9), 0).show();
    }

    private final void Mh(List<? extends ej> roleList) {
        this.mRoleList = roleList;
        int size = roleList.size();
        if (size != 0) {
            if (size != 1) {
                Dh().setText(roleList.get(0).getRoleName());
                Ch().setTag(roleList.get(0).getRoleId());
                Bh().setVisibility(0);
                Eh().setEnabled(true);
                return;
            }
            Dh().setText(roleList.get(0).getRoleName());
            Ch().setTag(roleList.get(0).getRoleId());
            Bh().setVisibility(4);
            Eh().setEnabled(true);
            return;
        }
        QQToast.makeText(MobileQQ.sMobileQQ.getApplicationContext(), getResources().getString(R.string.f155751ic), 0).show();
        Eh().setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Nh(final int index, p area) {
        if (!Intrinsics.areEqual(this.mItemTextList.get(index).getText(), area.getDesc())) {
            zh(index);
        }
        final boolean z16 = true;
        if (index != this.mAreaLevelList.size() - 1) {
            z16 = false;
        }
        this.mItemTextList.get(index).setText(area.getDesc());
        if (!z16) {
            this.mItemTextList.get(index + 1).setTag(area.getId());
        }
        ((IGPSService) ch.l().getRuntimeService(IGPSService.class, "")).getAppRoleList(this.mParams.z(), area.getId(), null, new bf() { // from class: com.tencent.mobileqq.guild.client.selectaccount.o
            @Override // vh2.bf
            public final void a(int i3, String str, String str2, List list, String str3, String str4, int i16, dd ddVar, ArrayList arrayList) {
                GuildClientSelectZoneDialogFragment.Oh(GuildClientSelectZoneDialogFragment.this, z16, index, i3, str, str2, list, str3, str4, i16, ddVar, arrayList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Oh(GuildClientSelectZoneDialogFragment this$0, boolean z16, int i3, int i16, String str, String str2, List roleList, String str3, String str4, int i17, dd ddVar, ArrayList arrayList) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(roleList, "roleList");
        this$0.Lh(i16, z16, roleList, ddVar, i17, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ph(p info) {
        Dh().setText(info.getDesc());
        Ch().setTag(info.getId());
    }

    private final void Qh() {
        Object tag;
        if (Ch().getTag() == null) {
            tag = "null";
        } else {
            tag = Ch().getTag();
        }
        com.tencent.mobileqq.guild.safety.j.d("GuildClientSelectZoneDialogFragment", "onSubmit | role tag: " + tag);
        IGPSService iGPSService = (IGPSService) ch.l().getRuntimeService(IGPSService.class, "");
        String z16 = this.mParams.z();
        Object tag2 = Ch().getTag();
        Intrinsics.checkNotNull(tag2, "null cannot be cast to non-null type kotlin.String");
        iGPSService.bindAppRole(z16, (String) tag2, 1, new vh2.d() { // from class: com.tencent.mobileqq.guild.client.selectaccount.n
            @Override // vh2.d
            public final void a(int i3, String str, String str2, String str3, int i16) {
                GuildClientSelectZoneDialogFragment.Rh(GuildClientSelectZoneDialogFragment.this, i3, str, str2, str3, i16);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Rh(GuildClientSelectZoneDialogFragment this$0, int i3, String str, String str2, String str3, int i16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i3 != 0) {
            ch.t1(MobileQQ.sMobileQQ.getApplicationContext(), -1, MobileQQ.sMobileQQ.getApplicationContext().getString(R.string.f142420jb), null);
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("bindAppRole network error, errorCode: %d, errorMessage: %s", Arrays.copyOf(new Object[]{Integer.valueOf(i3), str}, 2));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            QLog.e("GuildClientSelectZoneDialogFragment", 1, format);
            this$0.dismiss();
            return;
        }
        QLog.i("GuildClientSelectZoneDialogFragment", 1, "requestBindClientRole success");
        ch.u1(MobileQQ.sMobileQQ.getApplicationContext(), MobileQQ.sMobileQQ.getApplicationContext().getString(R.string.f142430jc));
        jg1.b.b(QBaseActivity.sTopActivity, this$0.getTargetFragment(), this$0.mParams, true);
    }

    private final void Sh() {
        final FragmentActivity activity;
        List<TextView> list = this.mItemTextList;
        if (Intrinsics.areEqual(list.get(list.size() - 1).getText(), "")) {
            Wh();
            return;
        }
        if (this.mRoleList.size() > 1) {
            List<TextView> list2 = this.mItemTextList;
            if (list2.get(list2.size() - 1).getTag() != null && (activity = getActivity()) != null) {
                Dialog dialog = getDialog();
                Intrinsics.checkNotNull(dialog, "null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
                ((com.google.android.material.bottomsheet.a) dialog).getBehavior().setState(4);
                ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.client.selectaccount.l
                    @Override // java.lang.Runnable
                    public final void run() {
                        GuildClientSelectZoneDialogFragment.Th(GuildClientSelectZoneDialogFragment.this, activity);
                    }
                }, 100L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Th(final GuildClientSelectZoneDialogFragment this$0, FragmentActivity act) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(act, "$act");
        String string = this$0.getResources().getString(R.string.f155761id);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st\u2026g.guild_select_zone_role)");
        String z16 = this$0.mParams.z();
        Intrinsics.checkNotNullExpressionValue(z16, "mParams.clientId");
        Object tag = this$0.mItemTextList.get(r3.size() - 1).getTag();
        Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type kotlin.String");
        GuildClientSelectRoleDialogFragment guildClientSelectRoleDialogFragment = new GuildClientSelectRoleDialogFragment(string, z16, (String) tag);
        guildClientSelectRoleDialogFragment.Ph(new Function1<p, Unit>() { // from class: com.tencent.mobileqq.guild.client.selectaccount.GuildClientSelectZoneDialogFragment$selectRole$1$1$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(p pVar) {
                invoke2(pVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull p info) {
                Intrinsics.checkNotNullParameter(info, "info");
                GuildClientSelectZoneDialogFragment.this.Ph(info);
            }
        });
        guildClientSelectRoleDialogFragment.Oh(this$0);
        guildClientSelectRoleDialogFragment.Th(this$0.mRoleList);
        guildClientSelectRoleDialogFragment.Qh(this$0.Dh().getText().toString());
        FragmentManager supportFragmentManager = act.getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "act.supportFragmentManager");
        com.tencent.mobileqq.guild.base.extension.d.a(guildClientSelectRoleDialogFragment, supportFragmentManager, "GuildClientSelectZoneDialogFragment");
    }

    private final void Uh(final int index, final GuildClientSelectListDialogFragment fragment) {
        final FragmentActivity activity = getActivity();
        if (activity != null) {
            Dialog dialog = getDialog();
            Intrinsics.checkNotNull(dialog, "null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
            ((com.google.android.material.bottomsheet.a) dialog).getBehavior().setState(4);
            ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.client.selectaccount.m
                @Override // java.lang.Runnable
                public final void run() {
                    GuildClientSelectZoneDialogFragment.Vh(GuildClientSelectListDialogFragment.this, this, index, activity);
                }
            }, 100L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Vh(GuildClientSelectListDialogFragment fragment, final GuildClientSelectZoneDialogFragment this$0, final int i3, FragmentActivity act) {
        Intrinsics.checkNotNullParameter(fragment, "$fragment");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(act, "$act");
        fragment.Ph(new Function1<p, Unit>() { // from class: com.tencent.mobileqq.guild.client.selectaccount.GuildClientSelectZoneDialogFragment$showSelectListDialog$1$1$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(p pVar) {
                invoke2(pVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull p info) {
                Intrinsics.checkNotNullParameter(info, "info");
                GuildClientSelectZoneDialogFragment.this.Nh(i3, info);
            }
        });
        fragment.Nh(this$0.mDataList.get(i3));
        fragment.Oh(this$0);
        fragment.Qh(this$0.mItemTextList.get(i3).getText().toString());
        FragmentManager supportFragmentManager = act.getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "act.supportFragmentManager");
        com.tencent.mobileqq.guild.base.extension.d.a(fragment, supportFragmentManager, "GuildClientSelectZoneDialogFragment");
    }

    private final void Wh() {
        Context applicationContext = MobileQQ.sMobileQQ.getApplicationContext();
        String string = getResources().getString(R.string.f155661i4);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st\u2026select_need_select_toast)");
        String format = String.format(string, Arrays.copyOf(new Object[]{this.mAreaLevelList.get(this.mCurrentSelectIndex).getDesc()}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        QQToast.makeText(applicationContext, format, 0).show();
    }

    private final void initData() {
        int size = this.mAreaLevelList.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.mDataList.add(null);
        }
        this.mDataList.set(0, this.area0List);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initView() {
        TextView Fh = Fh();
        String string = getResources().getString(R.string.f155771ie);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st\u2026.guild_select_zone_title)");
        String format = String.format(string, Arrays.copyOf(new Object[]{this.mParams.A()}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        Fh.setText(format);
        int size = this.mAreaLevelList.size();
        for (final int i3 = 0; i3 < size; i3++) {
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.f8_, Ah(), false);
            TextView textView = (TextView) inflate.findViewById(R.id.dq7);
            textView.setText(this.mAreaLevelList.get(i3).getDesc());
            textView.setTag(null);
            List<TextView> list = this.mItemTextList;
            View findViewById = inflate.findViewById(R.id.xxi);
            Intrinsics.checkNotNullExpressionValue(findViewById, "it.findViewById(R.id.item_select_tv)");
            list.add(findViewById);
            Ah().addView(inflate);
            inflate.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.client.selectaccount.i
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GuildClientSelectZoneDialogFragment.Gh(GuildClientSelectZoneDialogFragment.this, i3, view);
                }
            });
        }
        this.mItemTextList.get(0).setTag("");
        Eh().setEnabled(false);
        Eh().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.client.selectaccount.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildClientSelectZoneDialogFragment.Hh(GuildClientSelectZoneDialogFragment.this, view);
            }
        });
        Dh().setText("");
        Bh().setVisibility(4);
        Ch().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.client.selectaccount.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildClientSelectZoneDialogFragment.Ih(GuildClientSelectZoneDialogFragment.this, view);
            }
        });
        Dialog dialog = getDialog();
        Intrinsics.checkNotNull(dialog, "null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        ((com.google.android.material.bottomsheet.a) dialog).getBehavior().setPeekHeight(0);
        Dialog dialog2 = getDialog();
        Intrinsics.checkNotNull(dialog2, "null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        ((com.google.android.material.bottomsheet.a) dialog2).getBehavior().setState(3);
    }

    private final void zh(int index) {
        int size = this.mItemTextList.size();
        for (int i3 = index + 1; i3 < size; i3++) {
            this.mItemTextList.get(i3).setText(getResources().getString(R.string.f1518718v));
        }
        Dh().setText("");
        Bh().setVisibility(4);
        Eh().setEnabled(false);
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.appcompat.app.AppCompatDialogFragment, com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment, androidx.fragment.app.DialogFragment
    @NotNull
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Dialog onCreateDialog = super.onCreateDialog(savedInstanceState);
        Intrinsics.checkNotNull(onCreateDialog, "null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) onCreateDialog;
        Window window = aVar.getWindow();
        Intrinsics.checkNotNull(window);
        window.getAttributes().windowAnimations = R.style.f174032aw0;
        return aVar;
    }

    @Override // androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.ejk, container, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou\u2026agment, container, false)");
        this.mRootView = inflate;
        initView();
        initData();
        View view = this.mRootView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view = null;
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        View view = this.mRootView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view = null;
        }
        ((ViewGroup) view.getRootView().findViewById(R.id.ugk)).setBackgroundResource(17170445);
    }
}
