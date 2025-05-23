package com.tencent.mobileqq.zootopia.portal.detail.rank;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.component.cache.database.table.photo.LocalPhotoFaceInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.widget.RoundImageView;
import com.tencent.mobileqq.zootopia.portal.detail.rank.l;
import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.data.ZootopiaMapTab;
import com.tencent.sqshow.zootopia.utils.ae;
import fi3.t;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import t74.m;
import zb3.ZootopiaRankConfigData;
import zb3.ZootopiaRankShowInfo;
import zb3.ZootopiaUserRankData;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 X2\u00020\u0001:\u0002YZB'\b\u0007\u0012\u0006\u0010R\u001a\u00020Q\u0012\n\b\u0002\u0010T\u001a\u0004\u0018\u00010S\u0012\b\b\u0002\u0010U\u001a\u00020\t\u00a2\u0006\u0004\bV\u0010WJ\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u001e\u0010\u000b\u001a\u00020\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00022\u0006\u0010\n\u001a\u00020\tH\u0002J4\u0010\u0011\u001a\u00020\u00102\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00022\u0006\u0010\r\u001a\u00020\t2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u00022\u0006\u0010\u000f\u001a\u00020\tH\u0002J\u0018\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0007H\u0002J\u0010\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\b\u0010\u0019\u001a\u00020\u0005H\u0002J\u0010\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001aH\u0002J\u0010\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\tH\u0002J\u0010\u0010!\u001a\u00020\u00052\b\u0010 \u001a\u0004\u0018\u00010\u001fJ\u0016\u0010$\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u00102\u0006\u0010#\u001a\u00020\tJ$\u0010(\u001a\u00020\u00052\u0006\u0010&\u001a\u00020%2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\n\u001a\u00020\tR\u0014\u0010,\u001a\u00020)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0018\u0010 \u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0018\u00100\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010/R\u001c\u00102\u001a\b\u0012\u0004\u0012\u00020\u00070\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u00101R&\u00107\u001a\u0012\u0012\u0004\u0012\u00020403j\b\u0012\u0004\u0012\u000204`58\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u00106R0\u0010;\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000708j\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0007`98\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010:R0\u0010=\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u001208j\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0012`98\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b<\u0010:R\u0014\u0010A\u001a\u00020>8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b?\u0010@R$\u0010I\u001a\u0004\u0018\u00010B8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bC\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR$\u0010P\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010M\"\u0004\bN\u0010O\u00a8\u0006["}, d2 = {"Lcom/tencent/mobileqq/zootopia/portal/detail/rank/ZootopiaDetailRankHeaderView;", "Landroid/widget/RelativeLayout;", "", "Lzb3/p;", "rankDataList", "", "l", "Lzb3/m;", "filterList", "", "curFilterSwitchType", "j", "oldFilterList", "oldSwitchType", "newFilterList", "newSwitchType", "", "g", "Landroid/widget/RadioButton;", "radioButton", "rankShowInfo", DomainData.DOMAIN_NAME, "Lzb3/j;", "rankData", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "filterName", "o", "resId", "f", "Lcom/tencent/mobileqq/zootopia/portal/detail/rank/l;", "vm", "setViewModel", ViewStickEventHelper.IS_SHOW, "loadingViewStatus", "i", "Lzb3/k;", "zootopiaRankData", "curFullList", tl.h.F, "Lfi3/t;", "d", "Lfi3/t;", "binding", "e", "Lcom/tencent/mobileqq/zootopia/portal/detail/rank/l;", "Lzb3/j;", "rankConfigData", "Ljava/util/List;", "switchShowList", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/zootopia/portal/detail/rank/ZootopiaDetailRankHeaderView$b;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "first3RankItemViewList", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "filterSwitchIdMap", BdhLogUtil.LogTag.Tag_Conn, "filterSwitchIdView", "Lid3/d;", "D", "Lid3/d;", "reportHelper", "Lcom/tencent/sqshow/zootopia/data/n;", "E", "Lcom/tencent/sqshow/zootopia/data/n;", "getMapTabInfo", "()Lcom/tencent/sqshow/zootopia/data/n;", "setMapTabInfo", "(Lcom/tencent/sqshow/zootopia/data/n;)V", "mapTabInfo", UserInfo.SEX_FEMALE, "Ljava/lang/Integer;", "getCurCheckedId", "()Ljava/lang/Integer;", "setCurCheckedId", "(Ljava/lang/Integer;)V", "curCheckedId", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "G", "a", "b", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZootopiaDetailRankHeaderView extends RelativeLayout {

    /* renamed from: C, reason: from kotlin metadata */
    private final HashMap<Integer, RadioButton> filterSwitchIdView;

    /* renamed from: D, reason: from kotlin metadata */
    private final id3.d reportHelper;

    /* renamed from: E, reason: from kotlin metadata */
    private ZootopiaMapTab mapTabInfo;

    /* renamed from: F, reason: from kotlin metadata */
    private Integer curCheckedId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final t binding;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private l vm;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ZootopiaRankConfigData rankConfigData;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private List<ZootopiaRankShowInfo> switchShowList;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private ArrayList<b> first3RankItemViewList;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final HashMap<Integer, ZootopiaRankShowInfo> filterSwitchIdMap;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001BC\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\f\u00a2\u0006\u0004\b\u0017\u0010\u0018R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\t\u001a\u0004\b\u0003\u0010\nR\u0019\u0010\u0010\u001a\u0004\u0018\u00010\f8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\r\u0010\u000fR\u0019\u0010\u0012\u001a\u0004\u0018\u00010\f8\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0011\u0010\u000fR\u0019\u0010\u0014\u001a\u0004\u0018\u00010\f8\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0013\u0010\u000fR\u0019\u0010\u0016\u001a\u0004\u0018\u00010\f8\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u000e\u001a\u0004\b\u0015\u0010\u000f\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/zootopia/portal/detail/rank/ZootopiaDetailRankHeaderView$b;", "", "Landroid/widget/ImageView;", "a", "Landroid/widget/ImageView;", "b", "()Landroid/widget/ImageView;", "avatarBg", "Lcom/tencent/mobileqq/widget/RoundImageView;", "Lcom/tencent/mobileqq/widget/RoundImageView;", "()Lcom/tencent/mobileqq/widget/RoundImageView;", "avatar", "Landroid/widget/TextView;", "c", "Landroid/widget/TextView;", "()Landroid/widget/TextView;", "nick", "d", LocalPhotoFaceInfo.SCORE, "e", "scoreEndFix", "f", "title", "<init>", "(Landroid/widget/ImageView;Lcom/tencent/mobileqq/widget/RoundImageView;Landroid/widget/TextView;Landroid/widget/TextView;Landroid/widget/TextView;Landroid/widget/TextView;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final ImageView avatarBg;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final RoundImageView avatar;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private final TextView nick;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final TextView score;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final TextView scoreEndFix;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private final TextView title;

        public b(ImageView imageView, RoundImageView roundImageView, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
            this.avatarBg = imageView;
            this.avatar = roundImageView;
            this.nick = textView;
            this.score = textView2;
            this.scoreEndFix = textView3;
            this.title = textView4;
        }

        /* renamed from: a, reason: from getter */
        public final RoundImageView getAvatar() {
            return this.avatar;
        }

        /* renamed from: b, reason: from getter */
        public final ImageView getAvatarBg() {
            return this.avatarBg;
        }

        /* renamed from: c, reason: from getter */
        public final TextView getNick() {
            return this.nick;
        }

        /* renamed from: d, reason: from getter */
        public final TextView getScore() {
            return this.score;
        }

        /* renamed from: e, reason: from getter */
        public final TextView getScoreEndFix() {
            return this.scoreEndFix;
        }

        /* renamed from: f, reason: from getter */
        public final TextView getTitle() {
            return this.title;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ZootopiaDetailRankHeaderView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(ZootopiaDetailRankHeaderView this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (com.tencent.sqshow.zootopia.utils.h.b("rankRule")) {
            return;
        }
        ZootopiaRankConfigData zootopiaRankConfigData = this$0.rankConfigData;
        if (TextUtils.isEmpty(zootopiaRankConfigData != null ? zootopiaRankConfigData.getRankHelpDesc() : null)) {
            return;
        }
        this$0.q();
    }

    private final String f(int resId) {
        String string = getContext().getResources().getString(resId);
        Intrinsics.checkNotNullExpressionValue(string, "context.resources.getString(resId)");
        return string;
    }

    private final void j(List<ZootopiaRankShowInfo> filterList, int curFilterSwitchType) {
        String str;
        ZootopiaRankShowInfo zootopiaRankShowInfo = this.filterSwitchIdMap.get(Integer.valueOf(this.binding.f399368k.getCheckedRadioButtonId()));
        if (filterList.size() > 3) {
            filterList = filterList.subList(0, 3);
        }
        if (g(this.switchShowList, zootopiaRankShowInfo != null ? zootopiaRankShowInfo.getShowType() : -1, filterList, curFilterSwitchType)) {
            return;
        }
        this.switchShowList = filterList;
        this.binding.f399368k.setOnCheckedChangeListener(null);
        this.binding.f399368k.removeAllViews();
        this.filterSwitchIdMap.clear();
        this.filterSwitchIdView.clear();
        this.curCheckedId = null;
        int size = this.switchShowList.size();
        for (int i3 = 0; i3 < size; i3++) {
            ZootopiaRankShowInfo zootopiaRankShowInfo2 = this.switchShowList.get(i3);
            boolean isOn = zootopiaRankShowInfo2.getIsOn();
            RadioButton radioButton = new RadioButton(getContext());
            radioButton.setGravity(16);
            radioButton.setIncludeFontPadding(false);
            radioButton.setTextSize(11.0f);
            Resources resources = getContext().getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "context.resources");
            radioButton.setButtonDrawable(com.tencent.mobileqq.mvvm.f.c(resources, R.drawable.gys));
            radioButton.setTextColor(-1);
            radioButton.setAlpha(isOn ? 1.0f : 0.7f);
            String showName = zootopiaRankShowInfo2.getShowName();
            if (i3 < this.switchShowList.size() - 1) {
                str = "    ";
            } else {
                str = "";
            }
            radioButton.setText("  " + showName + str);
            radioButton.setTag(zootopiaRankShowInfo2);
            radioButton.setId(View.generateViewId());
            radioButton.setChecked(zootopiaRankShowInfo2.getShowType() == curFilterSwitchType);
            if (radioButton.isChecked()) {
                this.curCheckedId = Integer.valueOf(radioButton.getId());
            }
            n(radioButton, zootopiaRankShowInfo2);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            this.filterSwitchIdMap.put(Integer.valueOf(radioButton.getId()), zootopiaRankShowInfo2);
            this.filterSwitchIdView.put(Integer.valueOf(radioButton.getId()), radioButton);
            this.binding.f399368k.addView(radioButton, layoutParams);
        }
        this.binding.f399368k.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.zootopia.portal.detail.rank.j
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup, int i16) {
                ZootopiaDetailRankHeaderView.k(ZootopiaDetailRankHeaderView.this, radioGroup, i16);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(ZootopiaDetailRankHeaderView this$0, RadioGroup radioGroup, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ZootopiaRankShowInfo zootopiaRankShowInfo = this$0.filterSwitchIdMap.get(Integer.valueOf(i3));
        RadioButton radioButton = this$0.filterSwitchIdView.get(Integer.valueOf(i3));
        QLog.i("ZootopiaDetailRankHeaderView", 1, "radio OnCheckedChange - checkedId = " + i3 + " , data = " + zootopiaRankShowInfo);
        if (zootopiaRankShowInfo != null) {
            if (zootopiaRankShowInfo.getIsOn()) {
                Integer num = this$0.curCheckedId;
                if (num == null || num.intValue() != i3) {
                    this$0.curCheckedId = Integer.valueOf(i3);
                    l lVar = this$0.vm;
                    if (lVar != null) {
                        lVar.f2(zootopiaRankShowInfo);
                    }
                }
            } else {
                this$0.o(zootopiaRankShowInfo.getShowName());
                RadioGroup radioGroup2 = this$0.binding.f399368k;
                Integer num2 = this$0.curCheckedId;
                if (num2 != null) {
                    i3 = num2.intValue();
                }
                radioGroup2.check(i3);
            }
        }
        if (radioButton != null) {
            this$0.reportHelper.c("clck", radioButton, new LinkedHashMap());
        }
    }

    private final void l(List<ZootopiaUserRankData> rankDataList) {
        Resources resources = getContext().getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "context.resources");
        Drawable c16 = com.tencent.mobileqq.mvvm.f.c(resources, R.drawable.ibh);
        int size = this.first3RankItemViewList.size();
        int i3 = 0;
        while (i3 < size) {
            b bVar = this.first3RankItemViewList.get(i3);
            Intrinsics.checkNotNullExpressionValue(bVar, "first3RankItemViewList[rankIndex]");
            b bVar2 = bVar;
            int i16 = i3 < rankDataList.size() ? 0 : 8;
            ImageView avatarBg = bVar2.getAvatarBg();
            if (avatarBg != null) {
                avatarBg.setVisibility(i16);
            }
            RoundImageView avatar = bVar2.getAvatar();
            if (avatar != null) {
                avatar.setVisibility(i16);
            }
            TextView nick = bVar2.getNick();
            if (nick != null) {
                nick.setVisibility(i16);
            }
            TextView score = bVar2.getScore();
            if (score != null) {
                score.setVisibility(i16);
            }
            TextView scoreEndFix = bVar2.getScoreEndFix();
            if (scoreEndFix != null) {
                scoreEndFix.setVisibility(i16);
            }
            TextView title = bVar2.getTitle();
            if (title != null) {
                title.setVisibility(i16);
            }
            if (i3 < rankDataList.size()) {
                ZootopiaUserRankData zootopiaUserRankData = rankDataList.get(i3);
                TextView nick2 = bVar2.getNick();
                if (nick2 != null) {
                    nick2.setText(zootopiaUserRankData.h());
                }
                TextView score2 = bVar2.getScore();
                if (score2 != null) {
                    score2.setText(zootopiaUserRankData.getScore());
                }
                TextView scoreEndFix2 = bVar2.getScoreEndFix();
                if (scoreEndFix2 != null) {
                    scoreEndFix2.setText(zootopiaUserRankData.getScoreSuffix());
                }
                ae.INSTANCE.a(bVar2.getAvatar(), zootopiaUserRankData.f(), c16, R.drawable.ibh);
            }
            i3++;
        }
    }

    private final void m(ZootopiaRankConfigData rankData) {
        int i3 = TextUtils.isEmpty(rankData.getRankTable()) ? 4 : 0;
        if (this.binding.f399370m.getVisibility() != i3) {
            this.binding.f399370m.setVisibility(i3);
        }
        this.rankConfigData = rankData;
        this.binding.f399369l.setText(rankData.getRankTable());
        ae.INSTANCE.a(this.binding.f399367j, rankData.getRankIcon(), null, R.drawable.f159838ic4);
    }

    private final void n(RadioButton radioButton, ZootopiaRankShowInfo rankShowInfo) {
        String str;
        id3.d dVar = this.reportHelper;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        ZootopiaMapTab zootopiaMapTab = this.mapTabInfo;
        linkedHashMap.put("zplan_playground_detail_tab_id", Integer.valueOf(zootopiaMapTab != null ? zootopiaMapTab.getTabId() : 0));
        ZootopiaMapTab zootopiaMapTab2 = this.mapTabInfo;
        if (zootopiaMapTab2 == null || (str = zootopiaMapTab2.getTabName()) == null) {
            str = "";
        }
        linkedHashMap.put("zplan_playground_detail_tab_name", str);
        linkedHashMap.put("zplan_playground_detail_ranklist_id", Integer.valueOf(rankShowInfo.getShowType()));
        linkedHashMap.put("zplan_playground_detail_ranklist_name", rankShowInfo.getShowName());
        Unit unit = Unit.INSTANCE;
        id3.d.h(dVar, radioButton, "em_zplan_playground_ranklist_choice", linkedHashMap, false, false, null, 48, null);
    }

    public final void h(zb3.k zootopiaRankData, List<ZootopiaUserRankData> curFullList, int curFilterSwitchType) {
        Intrinsics.checkNotNullParameter(zootopiaRankData, "zootopiaRankData");
        Intrinsics.checkNotNullParameter(curFullList, "curFullList");
        m(zootopiaRankData.getRankConfig());
        l(curFullList);
        j(zootopiaRankData.getRankConfig().f(), curFilterSwitchType);
    }

    public final void i(boolean isShow, int loadingViewStatus) {
        QLog.i("ZootopiaDetailRankHeaderView", 1, "refreshLoadingStatus - isShow = " + isShow + " , loadingViewStatus = " + loadingViewStatus);
        int i3 = isShow ? 0 : 8;
        this.binding.f399371n.setVisibility(i3);
        this.binding.f399359b.setVisibility(i3);
        int i16 = isShow ? 8 : 0;
        this.binding.f399372o.setVisibility(i16);
        this.binding.f399366i.setVisibility(i16);
        if (isShow) {
            l.Companion companion = l.INSTANCE;
            if (loadingViewStatus == companion.d()) {
                this.binding.f399359b.b();
            } else if (loadingViewStatus == companion.b()) {
                this.binding.f399359b.a("\u52a0\u8f7d\u5931\u8d25");
            } else if (loadingViewStatus == companion.a()) {
                this.binding.f399359b.a("\u8be5\u6392\u884c\u699c\u6682\u65e0\u6392\u884c\u4fe1\u606f");
            }
        }
    }

    public final void setCurCheckedId(Integer num) {
        this.curCheckedId = num;
    }

    public final void setMapTabInfo(ZootopiaMapTab zootopiaMapTab) {
        this.mapTabInfo = zootopiaMapTab;
    }

    public final void setViewModel(l vm5) {
        this.vm = vm5;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ZootopiaDetailRankHeaderView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ ZootopiaDetailRankHeaderView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(DialogInterface dialogInterface, int i3) {
        if (dialogInterface != null) {
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(DialogInterface dialogInterface, int i3) {
        if (dialogInterface != null) {
            dialogInterface.dismiss();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZootopiaDetailRankHeaderView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        t f16 = t.f(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(f16, "inflate(LayoutInflater.from(context), this)");
        this.binding = f16;
        this.switchShowList = new ArrayList();
        this.first3RankItemViewList = new ArrayList<>();
        this.filterSwitchIdMap = new HashMap<>();
        this.filterSwitchIdView = new HashMap<>();
        this.reportHelper = new id3.d(null, 1, null);
        f16.f399370m.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zootopia.portal.detail.rank.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ZootopiaDetailRankHeaderView.e(ZootopiaDetailRankHeaderView.this, view);
            }
        });
        this.first3RankItemViewList.clear();
        this.first3RankItemViewList.add(new b(f16.f399361d, f16.f399360c, f16.f399362e, f16.f399363f, f16.f399364g, null));
        this.first3RankItemViewList.add(new b(f16.f399374q, f16.f399373p, f16.f399375r, f16.f399376s, f16.f399377t, f16.f399378u));
        this.first3RankItemViewList.add(new b(f16.f399380w, f16.f399379v, f16.f399381x, f16.f399382y, f16.f399383z, f16.A));
        int size = this.first3RankItemViewList.size();
        for (int i16 = 0; i16 < size; i16++) {
            b bVar = this.first3RankItemViewList.get(i16);
            Intrinsics.checkNotNullExpressionValue(bVar, "first3RankItemViewList[rankIndex]");
            b bVar2 = bVar;
            TextView title = bVar2.getTitle();
            if (title != null) {
                m mVar = m.f435564a;
                AssetManager assets = context.getAssets();
                Intrinsics.checkNotNullExpressionValue(assets, "context.assets");
                title.setTypeface(mVar.e(assets));
            }
            TextView score = bVar2.getScore();
            if (score != null) {
                m mVar2 = m.f435564a;
                AssetManager assets2 = context.getAssets();
                Intrinsics.checkNotNullExpressionValue(assets2, "context.assets");
                score.setTypeface(mVar2.e(assets2));
            }
            TextView scoreEndFix = bVar2.getScoreEndFix();
            if (scoreEndFix != null) {
                m mVar3 = m.f435564a;
                AssetManager assets3 = context.getAssets();
                Intrinsics.checkNotNullExpressionValue(assets3, "context.assets");
                scoreEndFix.setTypeface(mVar3.f(assets3));
            }
        }
    }

    private final boolean g(List<ZootopiaRankShowInfo> oldFilterList, int oldSwitchType, List<ZootopiaRankShowInfo> newFilterList, int newSwitchType) {
        if (oldSwitchType != newSwitchType || oldFilterList.size() != newFilterList.size()) {
            return false;
        }
        int size = newFilterList.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (oldFilterList.get(i3).getShowType() != newFilterList.get(i3).getShowType()) {
                return false;
            }
        }
        return true;
    }

    private final void o(String filterName) {
        String f16 = f(R.string.f169771xi3);
        String string = getContext().getResources().getString(R.string.xi7, filterName);
        Intrinsics.checkNotNullExpressionValue(string, "context.resources.getStr\u2026lter_disable, filterName)");
        DialogUtil.createCustomDialog(getContext(), 230, f16, string, (String) null, f(R.string.f169770xi2), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.zootopia.portal.detail.rank.k
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                ZootopiaDetailRankHeaderView.p(dialogInterface, i3);
            }
        }, (DialogInterface.OnClickListener) null).show();
    }

    private final void q() {
        String f16 = f(R.string.xi9);
        ZootopiaRankConfigData zootopiaRankConfigData = this.rankConfigData;
        DialogUtil.createCustomDialog(getContext(), 230, f16, zootopiaRankConfigData != null ? zootopiaRankConfigData.getRankHelpDesc() : null, (String) null, f(R.string.f169770xi2), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.zootopia.portal.detail.rank.i
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                ZootopiaDetailRankHeaderView.r(dialogInterface, i3);
            }
        }, (DialogInterface.OnClickListener) null).show();
    }
}
