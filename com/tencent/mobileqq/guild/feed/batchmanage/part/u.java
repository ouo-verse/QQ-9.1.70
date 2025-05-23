package com.tencent.mobileqq.guild.feed.batchmanage.part;

import aj1.b;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.PartIOCKt;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedBaseInitBean;
import com.tencent.mobileqq.guild.feed.util.au;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.guild.util.bi;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProCategoryChannelInfoList;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannel;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wh2.br;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00c4\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 o2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001pB\u000f\u0012\u0006\u0010B\u001a\u00020\u000b\u00a2\u0006\u0004\bn\u0010AJ\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\t\u001a\u00020\u0005H\u0002J\b\u0010\n\u001a\u00020\u0005H\u0002J$\u0010\u0010\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\u0007H\u0002J\u0018\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0003J\b\u0010\u0017\u001a\u00020\u0016H\u0002J\u0010\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0013H\u0002J8\u0010 \u001a\u0016\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001bj\n\u0012\u0004\u0012\u00020\u001f\u0018\u0001`\u001d2\u001a\u0010\u001e\u001a\u0016\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001bj\n\u0012\u0004\u0012\u00020\u001c\u0018\u0001`\u001dH\u0002J\b\u0010!\u001a\u00020\u0019H\u0002J\b\u0010\"\u001a\u00020\u0005H\u0002J\u0010\u0010$\u001a\u00020\u00192\u0006\u0010#\u001a\u00020\u0019H\u0002J \u0010*\u001a\u00020)2\u0006\u0010%\u001a\u00020\u00192\u0006\u0010&\u001a\u00020\u00192\u0006\u0010(\u001a\u00020'H\u0002J\u001c\u0010/\u001a\u00020\u00052\b\u0010,\u001a\u0004\u0018\u00010+2\b\u0010.\u001a\u0004\u0018\u00010-H\u0016J\u0010\u00101\u001a\u00020\u00052\u0006\u00100\u001a\u00020\u0013H\u0016J\u001c\u00105\u001a\u00020\u00052\b\u00102\u001a\u0004\u0018\u00010\u000b2\b\u00104\u001a\u0004\u0018\u000103H\u0016J\u0012\u00107\u001a\u00020\u00052\b\u00106\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u00108\u001a\u00020\u0005H\u0016J\u0012\u0010;\u001a\u00020\u00052\b\u0010:\u001a\u0004\u0018\u000109H\u0016R\"\u0010B\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u0016\u0010E\u001a\u00020\u00138\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010I\u001a\u00020F8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010M\u001a\u00020J8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bK\u0010LR\u0016\u0010Q\u001a\u00020N8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bO\u0010PR\u0016\u0010U\u001a\u00020R8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bS\u0010TR\u0018\u0010Y\u001a\u0004\u0018\u00010V8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bW\u0010XR\u001a\u0010]\u001a\b\u0012\u0004\u0012\u00020\u001f0Z8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b[\u0010\\R\u0016\u0010_\u001a\u00020F8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b^\u0010HR\u0016\u0010a\u001a\u00020\u00138\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b`\u0010DR\u0018\u0010e\u001a\u0004\u0018\u00010b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bc\u0010dR\u0014\u0010h\u001a\u00020\r8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bf\u0010gR\u0014\u0010j\u001a\u00020\u000b8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bi\u0010?R\u0016\u0010m\u001a\u0004\u0018\u00010\u00138VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\bk\u0010l\u00a8\u0006q"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/batchmanage/part/u;", "Lcom/tencent/biz/richframework/part/Part;", "Lco1/g;", "Laj1/b$a;", "Landroid/widget/PopupWindow$OnDismissListener;", "", "N9", "", "Q9", "U9", "P9", "", "channelName", "", "channelId", "needRefreshFeedCount", "D9", "Landroid/content/Context;", "context", "Landroid/view/View;", "anchorView", "V9", "Landroid/graphics/drawable/Drawable;", "G9", "view", "", "J9", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProCategoryChannelInfoList;", "Lkotlin/collections/ArrayList;", "infoList", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProChannel;", "I9", "H9", "T9", "tokenResId", "K9", "strokeColor", "radius", "", "strokeWidth", "Landroid/graphics/drawable/GradientDrawable;", "F9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "action", "", "args", "handleBroadcastMessage", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "I8", "onDismiss", "Landroid/content/res/Configuration;", "configuration", "onConfigurationChanged", "d", "Ljava/lang/String;", "getGuildId", "()Ljava/lang/String;", "setGuildId", "(Ljava/lang/String;)V", "guildId", "e", "Landroid/view/View;", "mRootView", "Landroid/widget/LinearLayout;", "f", "Landroid/widget/LinearLayout;", "llSection", "Landroid/widget/TextView;", tl.h.F, "Landroid/widget/TextView;", "sectionTitle", "Landroid/widget/ImageView;", "i", "Landroid/widget/ImageView;", "sectionArrow", "Laj1/b;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Laj1/b;", "adapter", "Lcom/tencent/mobileqq/guild/feed/batchmanage/viewmodel/e;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/guild/feed/batchmanage/viewmodel/e;", "viewModel", "", "D", "Ljava/util/List;", "dataList", "E", ParseCommon.CONTAINER, UserInfo.SEX_FEMALE, "mContainer", "Landroid/widget/PopupWindow;", "G", "Landroid/widget/PopupWindow;", "popupWindow", "L9", "()J", "selectedChannelId", "M9", "selectedChannelName", "O0", "()Landroid/view/View;", "hostView", "<init>", "H", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class u extends Part implements co1.g, b.a, PopupWindow.OnDismissListener {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.guild.feed.batchmanage.viewmodel.e viewModel;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final List<IGProChannel> dataList;

    /* renamed from: E, reason: from kotlin metadata */
    private LinearLayout container;

    /* renamed from: F, reason: from kotlin metadata */
    private View mContainer;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private PopupWindow popupWindow;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String guildId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private View mRootView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private LinearLayout llSection;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private TextView sectionTitle;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private ImageView sectionArrow;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private aj1.b adapter;

    public u(@NotNull String guildId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        this.guildId = guildId;
        this.dataList = new ArrayList();
    }

    private final void D9(String channelName, long channelId, boolean needRefreshFeedCount) {
        if (TextUtils.isEmpty(channelName)) {
            TextView textView = this.sectionTitle;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sectionTitle");
                textView = null;
            }
            textView.setText("\u7248\u5757\u7b5b\u9009");
            vi1.f fVar = (vi1.f) PartIOCKt.getIocInterface(this, vi1.f.class);
            if (fVar != null) {
                fVar.h(0L);
            }
            vi1.f fVar2 = (vi1.f) PartIOCKt.getIocInterface(this, vi1.f.class);
            if (fVar2 != null) {
                fVar2.a("");
            }
            T9();
        } else {
            TextView textView2 = this.sectionTitle;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sectionTitle");
                textView2 = null;
            }
            textView2.setText(channelName);
            vi1.f fVar3 = (vi1.f) PartIOCKt.getIocInterface(this, vi1.f.class);
            if (fVar3 != null) {
                fVar3.h(channelId);
            }
            vi1.f fVar4 = (vi1.f) PartIOCKt.getIocInterface(this, vi1.f.class);
            if (fVar4 != null) {
                if (channelName == null) {
                    channelName = "";
                }
                fVar4.a(channelName);
            }
            T9();
        }
        if (needRefreshFeedCount) {
            broadcastMessage("broadcast_refresh_feed_count", null);
        }
    }

    static /* synthetic */ void E9(u uVar, String str, long j3, boolean z16, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z16 = true;
        }
        uVar.D9(str, j3, z16);
    }

    private final GradientDrawable F9(int strokeColor, int radius, float strokeWidth) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(bi.b(radius));
        gradientDrawable.setStroke(bi.a(strokeWidth), strokeColor);
        return gradientDrawable;
    }

    private final Drawable G9() {
        int color = getContext().getColor(R.color.qui_common_bg_bottom_light);
        return GuildUIUtils.j(au.h(color, 0), au.h(color, 100), GradientDrawable.Orientation.TOP_BOTTOM, 0);
    }

    private final int H9() {
        if (Q9()) {
            return 3;
        }
        PopupWindow popupWindow = this.popupWindow;
        boolean z16 = false;
        if (popupWindow != null && popupWindow.isShowing()) {
            z16 = true;
        }
        if (!z16) {
            return 1;
        }
        return 2;
    }

    private final ArrayList<IGProChannel> I9(ArrayList<IGProCategoryChannelInfoList> infoList) {
        if (infoList != null) {
            Iterator<IGProCategoryChannelInfoList> it = infoList.iterator();
            while (it.hasNext()) {
                IGProCategoryChannelInfoList next = it.next();
                if (next.getCategoryType() == 1) {
                    return next.getChannelInfoList();
                }
            }
            return null;
        }
        return null;
    }

    private final int J9(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return iArr[1] + view.getHeight();
    }

    private final int K9(int tokenResId) {
        ie0.a f16 = ie0.a.f();
        View view = this.mRootView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view = null;
        }
        return f16.g(view.getContext(), tokenResId, 1000);
    }

    private final long L9() {
        vi1.f fVar = (vi1.f) PartIOCKt.getIocInterface(this, vi1.f.class);
        if (fVar != null) {
            return fVar.getSelectedChannelId();
        }
        return 0L;
    }

    private final String M9() {
        String selectedChannelName;
        vi1.f fVar = (vi1.f) PartIOCKt.getIocInterface(this, vi1.f.class);
        if (fVar == null || (selectedChannelName = fVar.getSelectedChannelName()) == null) {
            return "";
        }
        return selectedChannelName;
    }

    private final void N9() {
        com.tencent.mobileqq.guild.feed.batchmanage.viewmodel.e eVar = this.viewModel;
        if (eVar != null) {
            eVar.W1(this.guildId, new br() { // from class: com.tencent.mobileqq.guild.feed.batchmanage.part.t
                @Override // wh2.br
                public final void onGetCategoryChannelInfoListV2(ArrayList arrayList) {
                    u.O9(u.this, arrayList);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O9(u this$0, ArrayList arrayList) {
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ArrayList<IGProChannel> I9 = this$0.I9(arrayList);
        if (I9 != null && !I9.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        View view = null;
        if (z16) {
            View view2 = this$0.mRootView;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            } else {
                view = view2;
            }
            view.setVisibility(8);
            return;
        }
        View view3 = this$0.mRootView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
        } else {
            view = view3;
        }
        view.setVisibility(0);
    }

    private final void P9() {
        GuildFeedBaseInitBean a16;
        boolean z16;
        vi1.b bVar = (vi1.b) PartIOCKt.getIocInterface(this, vi1.b.class);
        if (bVar != null && (a16 = vi1.c.a(bVar)) != null) {
            String channelName = a16.getChannelName();
            if (channelName != null && channelName.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16 && !Intrinsics.areEqual(a16.getChannelId(), "0")) {
                String channelName2 = a16.getChannelName();
                String channelId = a16.getChannelId();
                Intrinsics.checkNotNullExpressionValue(channelId, "it.channelId");
                D9(channelName2, Long.parseLong(channelId), false);
            }
        }
    }

    private final boolean Q9() {
        if (L9() != 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R9(u this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.U9();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S9(u this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.Q9()) {
            aj1.b bVar = null;
            this$0.broadcastMessage("broadcast_clear", null);
            E9(this$0, "", 0L, false, 4, null);
            com.tencent.mobileqq.guild.feed.batchmanage.viewmodel.e eVar = this$0.viewModel;
            if (eVar != null) {
                eVar.X1(this$0.guildId, false);
            }
            aj1.b bVar2 = this$0.adapter;
            if (bVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                bVar2 = null;
            }
            bVar2.m0(0L);
            aj1.b bVar3 = this$0.adapter;
            if (bVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
            } else {
                bVar = bVar3;
            }
            bVar.notifyDataSetChanged();
        } else {
            this$0.U9();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void T9() {
        Drawable drawable;
        int H9 = H9();
        ImageView imageView = null;
        if (H9 != 1 && H9 != 2) {
            if (H9 == 3) {
                int K9 = K9(R.color.qui_common_brand_standard);
                LinearLayout linearLayout = this.llSection;
                if (linearLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("llSection");
                    linearLayout = null;
                }
                linearLayout.setBackground(F9(K9, 100, 0.7f));
                TextView textView = this.sectionTitle;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("sectionTitle");
                    textView = null;
                }
                textView.setTextColor(K9);
                LinearLayout linearLayout2 = this.llSection;
                if (linearLayout2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("llSection");
                    linearLayout2 = null;
                }
                Drawable drawable2 = linearLayout2.getContext().getResources().getDrawable(R.drawable.guild_feed_batcn_close_brand_standard);
                ImageView imageView2 = this.sectionArrow;
                if (imageView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("sectionArrow");
                } else {
                    imageView = imageView2;
                }
                imageView.setImageDrawable(drawable2);
                return;
            }
            return;
        }
        int K92 = K9(R.color.qui_common_icon_tertiary);
        LinearLayout linearLayout3 = this.llSection;
        if (linearLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("llSection");
            linearLayout3 = null;
        }
        linearLayout3.setBackground(F9(K92, 100, 0.7f));
        int K93 = K9(R.color.qui_common_text_primary);
        TextView textView2 = this.sectionTitle;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sectionTitle");
            textView2 = null;
        }
        textView2.setTextColor(K93);
        if (H9 == 1) {
            LinearLayout linearLayout4 = this.llSection;
            if (linearLayout4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("llSection");
                linearLayout4 = null;
            }
            drawable = linearLayout4.getContext().getResources().getDrawable(R.drawable.qui_chevron_down);
        } else {
            LinearLayout linearLayout5 = this.llSection;
            if (linearLayout5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("llSection");
                linearLayout5 = null;
            }
            drawable = linearLayout5.getContext().getResources().getDrawable(R.drawable.qui_chevron_up);
        }
        ImageView imageView3 = this.sectionArrow;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sectionArrow");
        } else {
            imageView = imageView3;
        }
        imageView.setImageDrawable(drawable);
    }

    private final void U9() {
        PopupWindow popupWindow = this.popupWindow;
        View view = null;
        if (popupWindow != null) {
            if (popupWindow != null) {
                popupWindow.setAnimationStyle(0);
            }
            PopupWindow popupWindow2 = this.popupWindow;
            if (popupWindow2 != null) {
                View view2 = this.mRootView;
                if (view2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mRootView");
                } else {
                    view = view2;
                }
                popupWindow2.showAsDropDown(view);
            }
        } else {
            View view3 = this.mRootView;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRootView");
                view3 = null;
            }
            Context context = view3.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "mRootView.context");
            View view4 = this.mRootView;
            if (view4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            } else {
                view = view4;
            }
            V9(context, view);
        }
        T9();
    }

    @SuppressLint({"MissingInflatedId"})
    private final void V9(Context context, View anchorView) {
        aj1.b bVar = null;
        View inflate = LayoutInflater.from(context).inflate(R.layout.ems, (ViewGroup) null);
        RecyclerView recyclerView = (RecyclerView) inflate.findViewById(R.id.f787747z);
        final LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.b8q);
        final View findViewById = inflate.findViewById(R.id.f11878753);
        final View findViewById2 = inflate.findViewById(R.id.abp);
        findViewById2.setVisibility(8);
        findViewById.setVisibility(8);
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.feed.batchmanage.part.r
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                u.W9(u.this, view);
            }
        });
        View view = this.mContainer;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContainer");
            view = null;
        }
        int height = view.getHeight() - J9(anchorView);
        int i3 = context.getResources().getDisplayMetrics().heightPixels;
        int J9 = J9(anchorView);
        View view2 = this.mContainer;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContainer");
            view2 = null;
        }
        QLog.d("GuildFeedBatchManageSectionPart", 1, " screenHeight " + height + " total " + i3 + ",  view " + J9 + " mContainer.height " + view2.getHeight());
        PopupWindow popupWindow = new PopupWindow(inflate, -1, height, true);
        this.popupWindow = popupWindow;
        popupWindow.setOnDismissListener(this);
        aj1.b bVar2 = this.adapter;
        if (bVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        } else {
            bVar = bVar2;
        }
        recyclerView.setAdapter(bVar);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        com.tencent.mobileqq.guild.feed.batchmanage.viewmodel.e eVar = this.viewModel;
        if (eVar != null) {
            eVar.W1(this.guildId, new br() { // from class: com.tencent.mobileqq.guild.feed.batchmanage.part.s
                @Override // wh2.br
                public final void onGetCategoryChannelInfoListV2(ArrayList arrayList) {
                    u.X9(u.this, findViewById, findViewById2, linearLayout, arrayList);
                }
            });
        }
        PopupWindow popupWindow2 = this.popupWindow;
        if (popupWindow2 != null) {
            popupWindow2.setAnimationStyle(0);
        }
        PopupWindow popupWindow3 = this.popupWindow;
        if (popupWindow3 != null) {
            popupWindow3.showAsDropDown(anchorView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W9(u this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        PopupWindow popupWindow = this$0.popupWindow;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X9(u this$0, View view, View view2, LinearLayout linearLayout, ArrayList arrayList) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ArrayList<IGProChannel> I9 = this$0.I9(arrayList);
        if (I9 != null) {
            this$0.dataList.clear();
            this$0.dataList.addAll(I9);
            aj1.b bVar = this$0.adapter;
            aj1.b bVar2 = null;
            if (bVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                bVar = null;
            }
            bVar.m0(Long.valueOf(this$0.L9()));
            aj1.b bVar3 = this$0.adapter;
            if (bVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
            } else {
                bVar2 = bVar3;
            }
            bVar2.notifyDataSetChanged();
            if (this$0.dataList.size() > 8) {
                view.setVisibility(0);
                view.setBackground(this$0.G9());
                view2.setVisibility(0);
                linearLayout.requestLayout();
            }
        }
    }

    @Override // aj1.b.a
    public void I8(@Nullable IGProChannel item) {
        if (item != null) {
            E9(this, item.getChannelName(), item.getChannelId(), false, 4, null);
            com.tencent.mobileqq.guild.feed.batchmanage.viewmodel.e eVar = this.viewModel;
            if (eVar != null) {
                eVar.U1(this.guildId, String.valueOf(item.getChannelId()), false);
            }
            QLog.d("GuildFeedBatchManageSectionPart", 1, "select channelId " + item.getChannelId() + ", guildId " + this.guildId);
        } else {
            E9(this, "", 0L, false, 4, null);
            com.tencent.mobileqq.guild.feed.batchmanage.viewmodel.e eVar2 = this.viewModel;
            if (eVar2 != null) {
                eVar2.X1(this.guildId, false);
            }
            QLog.d("GuildFeedBatchManageSectionPart", 1, "select channelId getFeedData");
        }
        broadcastMessage("broadcast_clear", null);
        PopupWindow popupWindow = this.popupWindow;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
    }

    @Override // co1.g
    @Nullable
    public View O0() {
        View view = this.mRootView;
        if (view != null) {
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            } else {
                return view;
            }
        }
        return null;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(@Nullable String action, @Nullable Object args) {
        if (Intrinsics.areEqual(action, "BROADCAST_REFRESH")) {
            E9(this, M9(), L9(), false, 4, null);
            aj1.b bVar = this.adapter;
            aj1.b bVar2 = null;
            if (bVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                bVar = null;
            }
            bVar.m0(Long.valueOf(L9()));
            aj1.b bVar3 = this.adapter;
            if (bVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
            } else {
                bVar2 = bVar3;
            }
            bVar2.notifyDataSetChanged();
            if (L9() != 0) {
                com.tencent.mobileqq.guild.feed.batchmanage.viewmodel.e eVar = this.viewModel;
                if (eVar != null) {
                    eVar.U1(this.guildId, String.valueOf(L9()), false);
                    return;
                }
                return;
            }
            com.tencent.mobileqq.guild.feed.batchmanage.viewmodel.e eVar2 = this.viewModel;
            if (eVar2 != null) {
                eVar2.X1(this.guildId, false);
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onConfigurationChanged(@Nullable Configuration configuration) {
        super.onConfigurationChanged(configuration);
        PopupWindow popupWindow = this.popupWindow;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        T9();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        View findViewById = rootView.findViewById(R.id.ymt);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.llSectionContent)");
        this.mRootView = findViewById;
        View findViewById2 = rootView.findViewById(R.id.ymu);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.llSectionSelect)");
        this.llSection = (LinearLayout) findViewById2;
        View findViewById3 = rootView.findViewById(R.id.f81754f1);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.id.sectionTitle)");
        this.sectionTitle = (TextView) findViewById3;
        View findViewById4 = rootView.findViewById(R.id.f81734ez);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.id.sectionArrow)");
        this.sectionArrow = (ImageView) findViewById4;
        View findViewById5 = rootView.findViewById(R.id.f166090ed2);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "rootView.findViewById(R.id.ll_container)");
        this.container = (LinearLayout) findViewById5;
        View findViewById6 = rootView.findViewById(R.id.f166798ic2);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "rootView.findViewById(R.id.rl_container)");
        this.mContainer = findViewById6;
        this.adapter = new aj1.b(this.dataList, this);
        N9();
        P9();
        T9();
        LinearLayout linearLayout = this.llSection;
        ImageView imageView = null;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("llSection");
            linearLayout = null;
        }
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.feed.batchmanage.part.p
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                u.R9(u.this, view);
            }
        });
        ImageView imageView2 = this.sectionArrow;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sectionArrow");
        } else {
            imageView = imageView2;
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.feed.batchmanage.part.q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                u.S9(u.this, view);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        super.onPartCreate(activity, savedInstanceState);
        this.viewModel = (com.tencent.mobileqq.guild.feed.batchmanage.viewmodel.e) getViewModel(com.tencent.mobileqq.guild.feed.batchmanage.viewmodel.e.class);
    }
}
