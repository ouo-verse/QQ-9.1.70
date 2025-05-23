package com.qzone.reborn.intimate.part;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.ViewModel;
import com.qzone.reborn.intimate.bean.QZIntimateSettingItemBean;
import com.qzone.reborn.intimate.bean.init.QZIntimateSettingPageBean;
import com.qzone.reborn.intimate.bean.init.QZoneIntimateAlbumSyncInitBean;
import com.qzone.reborn.intimate.event.QZIntimateModifyAnniversaryEvent;
import com.qzone.reborn.intimate.event.QZIntimateModifySettingEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView;
import com.tencent.mobileqq.widget.qus.QUSHalfScreenImmersiveFloatingView;
import com.tencent.mobileqq.widget.selectorview.QActionSheet;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qcircle.weseevideo.model.utils.LocaleUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.widget.Switch;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\n\u0018\u0000 U2\u00020\u0001:\u0001VB\u0007\u00a2\u0006\u0004\bS\u0010TJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\u0002H\u0002J\b\u0010\u000b\u001a\u00020\u0002H\u0002J\b\u0010\f\u001a\u00020\u0002H\u0002J\b\u0010\r\u001a\u00020\u0002H\u0002J\b\u0010\u000e\u001a\u00020\u0002H\u0002J \u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\b\u0010\u0017\u001a\u00020\u0016H\u0002J\u0010\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0014H\u0002J\u0010\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u000fH\u0002J\u0010\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0018\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u0012H\u0002J\u0010\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u0012H\u0002J\u0010\u0010 \u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u0012H\u0002J\u0010\u0010!\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u0012H\u0002J \u0010#\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u0012H\u0002J\u0018\u0010$\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u0012H\u0002J\u0010\u0010%\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u0012H\u0002J\u0010\u0010&\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u0012H\u0002J\u0010\u0010'\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u0012H\u0002J,\u0010+\u001a\u001e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020)0(j\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020)`*2\u0006\u0010\u001d\u001a\u00020\u0012H\u0002J\u0010\u0010,\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010-\u001a\u00020\u0002H\u0002J\b\u0010.\u001a\u00020\u0002H\u0002J\b\u0010/\u001a\u00020\u000fH\u0002J\b\u00100\u001a\u00020\u0002H\u0002J\b\u00101\u001a\u00020\u0002H\u0002J\u0012\u00103\u001a\u00020\u00022\b\u00102\u001a\u0004\u0018\u00010\u0016H\u0016J\u0012\u00106\u001a\u00020\u00022\b\u00105\u001a\u0004\u0018\u000104H\u0016R\u0016\u0010:\u001a\u0002078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010>\u001a\u00020;8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0018\u0010B\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0018\u0010F\u001a\u0004\u0018\u00010C8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0018\u0010H\u001a\u0004\u0018\u00010C8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010ER\u0018\u0010L\u001a\u0004\u0018\u00010I8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010KR\u001c\u0010P\u001a\b\u0012\u0004\u0012\u00020\u00140M8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bN\u0010OR\u001c\u0010R\u001a\b\u0012\u0004\u0012\u00020\u00140M8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bQ\u0010O\u00a8\u0006W"}, d2 = {"Lcom/qzone/reborn/intimate/part/bb;", "Lcom/qzone/reborn/base/k;", "", "initViewModel", "da", "N9", "ea", "", "settingNum", "H9", "qa", LocaleUtils.L_JAPANESE, "ca", "ia", "ba", "", "leftText", "rightText", "", "isShowSwitch", "Lcom/qzone/reborn/albumx/common/bean/i;", "J9", "Landroid/view/View;", "I9", "bean", "K9", "settingKey", "pa", "P9", com.tencent.mobileqq.msf.core.f0.c.e.h.f248218g, "R9", "W9", "aa", "Y9", "settingName", "Q9", "O9", "V9", "Z9", "X9", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "S9", "U9", "ma", "la", "T9", "na", "oa", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartResume", "Lnk/o;", "d", "Lnk/o;", "settingViewModel", "Lcom/qzone/reborn/intimate/bean/init/QZIntimateSettingPageBean;", "e", "Lcom/qzone/reborn/intimate/bean/init/QZIntimateSettingPageBean;", "settingPageBean", "Lcom/tencent/mobileqq/widget/qus/QUSHalfScreenImmersiveFloatingView;", "f", "Lcom/tencent/mobileqq/widget/qus/QUSHalfScreenImmersiveFloatingView;", "settingMenu", "Landroid/widget/LinearLayout;", tl.h.F, "Landroid/widget/LinearLayout;", "spaceSettingContainer", "i", "checkInSettingContainer", "Landroid/widget/TextView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/TextView;", "checkInSettingTitle", "", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/List;", "spaceSettingList", "D", "checkInSettingList", "<init>", "()V", "E", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class bb extends com.qzone.reborn.base.k {

    /* renamed from: C, reason: from kotlin metadata */
    private List<com.qzone.reborn.albumx.common.bean.i> spaceSettingList = new ArrayList();

    /* renamed from: D, reason: from kotlin metadata */
    private List<com.qzone.reborn.albumx.common.bean.i> checkInSettingList = new ArrayList();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private nk.o settingViewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private QZIntimateSettingPageBean settingPageBean;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private QUSHalfScreenImmersiveFloatingView settingMenu;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private LinearLayout spaceSettingContainer;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private LinearLayout checkInSettingContainer;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private TextView checkInSettingTitle;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/qzone/reborn/intimate/part/bb$b", "Lcom/tencent/mobileqq/widget/qus/QUSBaseHalfScreenFloatingView$o;", "", "a", "Landroid/view/View;", "v", "", NodeProps.ON_CLICK, "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b implements QUSBaseHalfScreenFloatingView.o {
        b() {
        }

        @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.o
        public void a() {
            bb.this.N9();
        }

        @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.o
        public boolean onClick(View v3) {
            return true;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/qzone/reborn/intimate/part/bb$c", "Lcom/tencent/mobileqq/widget/qus/e;", "Landroid/view/View;", "createContentView", "", "showMode", NodeProps.MAX_HEIGHT, "defaultHeight", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class c extends com.tencent.mobileqq.widget.qus.e {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f57419d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f57420e;

        c(View view, int i3) {
            this.f57419d = view;
            this.f57420e = i3;
        }

        @Override // com.tencent.mobileqq.widget.qus.d
        /* renamed from: createContentView, reason: from getter */
        public View getF57419d() {
            return this.f57419d;
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        /* renamed from: defaultHeight, reason: from getter */
        public int getF57420e() {
            return this.f57420e;
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int maxHeight() {
            return this.f57420e;
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int showMode() {
            return 1;
        }
    }

    private final int H9(int settingNum) {
        if (this.checkInSettingList.size() > 0) {
            return ef.d.b((settingNum * 56) + 158);
        }
        return ef.d.b((settingNum * 56) + 134);
    }

    private final View I9() {
        View item = LayoutInflater.from(getContext()).inflate(R.layout.f167319co3, (ViewGroup) null);
        item.setLayoutParams(new LinearLayout.LayoutParams(-1, ef.d.b(1)));
        Intrinsics.checkNotNullExpressionValue(item, "item");
        return item;
    }

    private final com.qzone.reborn.albumx.common.bean.i J9(String leftText, String rightText, boolean isShowSwitch) {
        com.qzone.reborn.albumx.common.bean.i iVar = new com.qzone.reborn.albumx.common.bean.i(leftText);
        iVar.d(rightText);
        iVar.e(isShowSwitch);
        return iVar;
    }

    private final View K9(final com.qzone.reborn.albumx.common.bean.i bean) {
        View item = LayoutInflater.from(getContext()).inflate(R.layout.f167318co2, (ViewGroup) null);
        TextView textView = (TextView) item.findViewById(R.id.f162919nb4);
        TextView textView2 = (TextView) item.findViewById(R.id.nb6);
        ImageView imageView = (ImageView) item.findViewById(R.id.nb5);
        Switch r46 = (Switch) item.findViewById(R.id.nb7);
        textView.setText(bean.getLeftText());
        if (TextUtils.isEmpty(bean.getRightTip())) {
            textView2.setVisibility(8);
        } else {
            textView2.setText(bean.getRightTip());
            textView2.setVisibility(0);
        }
        r46.setVisibility(bean.getIsShowSwitch() ? 0 : 8);
        imageView.setVisibility(bean.getIsShowSwitch() ? 8 : 0);
        final String U9 = U9(bean.getLeftText());
        r46.setChecked(pa(U9));
        R9(U9, r46.isChecked());
        r46.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.qzone.reborn.intimate.part.ay
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                bb.L9(U9, this, bean, compoundButton, z16);
            }
        });
        item.setLayoutParams(new LinearLayout.LayoutParams(-1, ef.d.b(56)));
        if (!bean.getIsShowSwitch()) {
            item.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.intimate.part.az
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    bb.M9(bb.this, bean, view);
                }
            });
        }
        Intrinsics.checkNotNullExpressionValue(item, "item");
        return item;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L9(String settingKey, bb this$0, com.qzone.reborn.albumx.common.bean.i bean, CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        Intrinsics.checkNotNullParameter(settingKey, "$settingKey");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(bean, "$bean");
        QLog.i("QZIntimateSpaceSettingPart", 1, "setting key is " + settingKey + ", is checked is " + z16);
        this$0.Q9(settingKey, bean.getLeftText(), z16);
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M9(bb this$0, com.qzone.reborn.albumx.common.bean.i bean, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(bean, "$bean");
        this$0.P9(bean.getLeftText());
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void N9() {
        QUSHalfScreenImmersiveFloatingView qUSHalfScreenImmersiveFloatingView = this.settingMenu;
        if (qUSHalfScreenImmersiveFloatingView != null) {
            qUSHalfScreenImmersiveFloatingView.t();
        }
    }

    private final void O9(String settingKey, boolean isOpen) {
        int hashCode = settingKey.hashCode();
        if (hashCode == -1987584687) {
            if (settingKey.equals("sync_friend_switch")) {
                X9(isOpen);
            }
        } else {
            if (hashCode != -1244268230) {
                if (hashCode == 1434155166 && settingKey.equals("signin_notice_switch")) {
                    V9(isOpen);
                    return;
                }
                return;
            }
            if (settingKey.equals("sync_qzone_switch")) {
                Z9(isOpen);
            }
        }
    }

    private final void Q9(String settingKey, String settingName, boolean isOpen) {
        String str;
        QZIntimateSettingItemBean qZIntimateSettingItemBean = new QZIntimateSettingItemBean();
        qZIntimateSettingItemBean.setKey(settingKey);
        qZIntimateSettingItemBean.setName(settingName);
        if (isOpen) {
            str = "true";
        } else {
            str = "false";
        }
        qZIntimateSettingItemBean.setValue(str);
        SimpleEventBus.getInstance().dispatchEvent(new QZIntimateModifySettingEvent(qZIntimateSettingItemBean));
        O9(settingKey, isOpen);
    }

    private final void R9(String settingKey, boolean isOpen) {
        int hashCode = settingKey.hashCode();
        if (hashCode == -1987584687) {
            if (settingKey.equals("sync_friend_switch")) {
                Y9(isOpen);
            }
        } else {
            if (hashCode != -1244268230) {
                if (hashCode == 1434155166 && settingKey.equals("signin_notice_switch")) {
                    W9(isOpen);
                    return;
                }
                return;
            }
            if (settingKey.equals("sync_qzone_switch")) {
                aa(isOpen);
            }
        }
    }

    private final HashMap<String, Object> S9(boolean isOpen) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("op_result", Integer.valueOf(isOpen ? 1 : 2));
        return hashMap;
    }

    private final String T9() {
        QZIntimateSettingPageBean qZIntimateSettingPageBean = this.settingPageBean;
        QZIntimateSettingPageBean qZIntimateSettingPageBean2 = null;
        if (qZIntimateSettingPageBean == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingPageBean");
            qZIntimateSettingPageBean = null;
        }
        if (!qZIntimateSettingPageBean.getIsSpaceDataReady()) {
            return "";
        }
        QZIntimateSettingPageBean qZIntimateSettingPageBean3 = this.settingPageBean;
        if (qZIntimateSettingPageBean3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingPageBean");
        } else {
            qZIntimateSettingPageBean2 = qZIntimateSettingPageBean3;
        }
        if (qZIntimateSettingPageBean2.getIsSpacePrivate()) {
            String a16 = com.qzone.util.l.a(R.string.w9e);
            Intrinsics.checkNotNullExpressionValue(a16, "{\n            HardCodeUt\u2026prompt_private)\n        }");
            return a16;
        }
        String a17 = com.qzone.util.l.a(R.string.w9f);
        Intrinsics.checkNotNullExpressionValue(a17, "{\n            HardCodeUt\u2026_prompt_public)\n        }");
        return a17;
    }

    private final void W9(boolean isOpen) {
        fo.c.g("em_qz_couple_space_punch_remind_switch", "pg_qz_settings_page_buddy", getPartRootView(), S9(isOpen));
    }

    private final void X9(boolean isOpen) {
        fo.c.e("em_qz_sync_opponent_switch", "pg_qz_settings_page_buddy", getPartRootView(), S9(isOpen));
    }

    private final void Y9(boolean isOpen) {
        fo.c.g("em_qz_sync_opponent_switch", "pg_qz_settings_page_buddy", getPartRootView(), S9(isOpen));
    }

    private final void Z9(boolean isOpen) {
        fo.c.e("em_qz_sync_qq_space_switch", "pg_qz_settings_page_buddy", getPartRootView(), S9(isOpen));
    }

    private final void aa(boolean isOpen) {
        fo.c.g("em_qz_sync_qq_space_switch", "pg_qz_settings_page_buddy", getPartRootView(), S9(isOpen));
    }

    private final void ba() {
        LinearLayout linearLayout;
        LinearLayout linearLayout2 = this.checkInSettingContainer;
        if (linearLayout2 != null) {
            linearLayout2.removeAllViews();
        }
        if (this.checkInSettingList.isEmpty()) {
            LinearLayout linearLayout3 = this.checkInSettingContainer;
            if (linearLayout3 != null) {
                linearLayout3.setVisibility(8);
            }
            TextView textView = this.checkInSettingTitle;
            if (textView == null) {
                return;
            }
            textView.setVisibility(8);
            return;
        }
        LinearLayout linearLayout4 = this.checkInSettingContainer;
        int i3 = 0;
        if (linearLayout4 != null) {
            linearLayout4.setVisibility(0);
        }
        TextView textView2 = this.checkInSettingTitle;
        if (textView2 != null) {
            textView2.setVisibility(0);
        }
        for (Object obj : this.checkInSettingList) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            com.qzone.reborn.albumx.common.bean.i iVar = (com.qzone.reborn.albumx.common.bean.i) obj;
            if (i3 > 0 && (linearLayout = this.checkInSettingContainer) != null) {
                linearLayout.addView(I9());
            }
            LinearLayout linearLayout5 = this.checkInSettingContainer;
            if (linearLayout5 != null) {
                linearLayout5.addView(K9(iVar));
            }
            i3 = i16;
        }
    }

    private final void ca() {
        QZIntimateSettingPageBean qZIntimateSettingPageBean = this.settingPageBean;
        if (qZIntimateSettingPageBean == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingPageBean");
            qZIntimateSettingPageBean = null;
        }
        List<QZIntimateSettingItemBean> settingList = qZIntimateSettingPageBean.getSettingList();
        if (settingList == null || settingList.isEmpty()) {
            return;
        }
        if (mk.d.f416875a.K()) {
            List<com.qzone.reborn.albumx.common.bean.i> list = this.checkInSettingList;
            String a16 = com.qzone.util.l.a(R.string.v8u);
            Intrinsics.checkNotNullExpressionValue(a16, "qqStr(R.string.qzone_int\u2026check_in_auto_sync_qzone)");
            list.add(J9(a16, "", true));
        }
        com.qzone.reborn.a aVar = com.qzone.reborn.a.f52169a;
        if (com.qzone.reborn.a.c(aVar, "exp_qz_qmkj_checkin", null, 2, null)) {
            List<com.qzone.reborn.albumx.common.bean.i> list2 = this.checkInSettingList;
            String a17 = com.qzone.util.l.a(R.string.v8t);
            Intrinsics.checkNotNullExpressionValue(a17, "qqStr(R.string.qzone_int\u2026eck_in_auto_remind_other)");
            list2.add(J9(a17, "", true));
        }
        if (com.qzone.reborn.a.e(aVar, "exp__space_clock_in_remind2", null, 2, null)) {
            List<com.qzone.reborn.albumx.common.bean.i> list3 = this.checkInSettingList;
            String a18 = com.qzone.util.l.a(R.string.v8v);
            Intrinsics.checkNotNullExpressionValue(a18, "qqStr(R.string.qzone_intimate_check_in_push)");
            list3.add(J9(a18, "", true));
        }
    }

    private final void da() {
        nk.o oVar = this.settingViewModel;
        nk.o oVar2 = null;
        if (oVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingViewModel");
            oVar = null;
        }
        if (TextUtils.isEmpty(oVar.getSpaceId())) {
            QLog.e("QZIntimateSpaceSettingPart", 1, "space id is empty");
            return;
        }
        com.qzone.reborn.util.i b16 = com.qzone.reborn.util.i.b();
        mk.d dVar = mk.d.f416875a;
        nk.o oVar3 = this.settingViewModel;
        if (oVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingViewModel");
            oVar3 = null;
        }
        if (b16.a(dVar.e(oVar3.getSpaceId()))) {
            nk.o oVar4 = this.settingViewModel;
            if (oVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("settingViewModel");
            } else {
                oVar2 = oVar4;
            }
            if (dVar.b(oVar2.getSpaceId())) {
                QLog.i("QZIntimateSpaceSettingPart", 1, "initOldSettingState");
                QZIntimateSettingItemBean qZIntimateSettingItemBean = new QZIntimateSettingItemBean();
                qZIntimateSettingItemBean.setKey("sync_qzone_switch");
                String a16 = com.qzone.util.l.a(R.string.v8u);
                Intrinsics.checkNotNullExpressionValue(a16, "qqStr(R.string.qzone_int\u2026check_in_auto_sync_qzone)");
                qZIntimateSettingItemBean.setName(a16);
                qZIntimateSettingItemBean.setValue("true");
                SimpleEventBus.getInstance().dispatchEvent(new QZIntimateModifySettingEvent(qZIntimateSettingItemBean));
            }
        }
    }

    private final void ea() {
        ja();
        ca();
        int H9 = H9(this.spaceSettingList.size() + this.checkInSettingList.size());
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.ckq, (ViewGroup) null);
        inflate.setLayoutParams(new FrameLayout.LayoutParams(-1, H9));
        this.spaceSettingContainer = (LinearLayout) inflate.findViewById(R.id.kr5);
        this.checkInSettingContainer = (LinearLayout) inflate.findViewById(R.id.f19676b);
        this.checkInSettingTitle = (TextView) inflate.findViewById(R.id.f19686c);
        QUSHalfScreenImmersiveFloatingView qUSHalfScreenImmersiveFloatingView = new QUSHalfScreenImmersiveFloatingView(getContext());
        qUSHalfScreenImmersiveFloatingView.setContentViewBackgroundResource(R.color.qui_common_bg_middle_standard);
        qUSHalfScreenImmersiveFloatingView.setIgnoreHorizontalMove(true);
        qUSHalfScreenImmersiveFloatingView.setDraggable(true);
        qUSHalfScreenImmersiveFloatingView.setOnOutsideClickListener(new b());
        qUSHalfScreenImmersiveFloatingView.setQUSDragFloatController(new c(inflate, H9));
        qUSHalfScreenImmersiveFloatingView.setOnDismissListener(new QUSBaseHalfScreenFloatingView.l() { // from class: com.qzone.reborn.intimate.part.ax
            @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.l
            public final void onDismiss() {
                bb.ga(bb.this);
            }
        });
        this.settingMenu = qUSHalfScreenImmersiveFloatingView;
        qUSHalfScreenImmersiveFloatingView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ga(final bb this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RFWThreadManager.getInstance().postMainDelay(new Runnable() { // from class: com.qzone.reborn.intimate.part.ba
            @Override // java.lang.Runnable
            public final void run() {
                bb.ha(bb.this);
            }
        }, 100L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ha(bb this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getActivity().finish();
    }

    private final void ia() {
        LinearLayout linearLayout;
        LinearLayout linearLayout2 = this.spaceSettingContainer;
        if (linearLayout2 != null) {
            linearLayout2.removeAllViews();
        }
        if (this.spaceSettingList.isEmpty()) {
            QLog.i("QZIntimateSpaceSettingPart", 1, "space setting list is empty");
            return;
        }
        int i3 = 0;
        for (Object obj : this.spaceSettingList) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            com.qzone.reborn.albumx.common.bean.i iVar = (com.qzone.reborn.albumx.common.bean.i) obj;
            if (i3 > 0 && (linearLayout = this.spaceSettingContainer) != null) {
                linearLayout.addView(I9());
            }
            LinearLayout linearLayout3 = this.spaceSettingContainer;
            if (linearLayout3 != null) {
                linearLayout3.addView(K9(iVar));
            }
            i3 = i16;
        }
    }

    private final void initViewModel() {
        ViewModel viewModel = getViewModel(nk.o.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(QZIntimateS\u2026ageViewModel::class.java)");
        nk.o oVar = (nk.o) viewModel;
        this.settingViewModel = oVar;
        if (oVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingViewModel");
            oVar = null;
        }
        QZIntimateSettingPageBean settingPageBean = oVar.getSettingPageBean();
        Intrinsics.checkNotNull(settingPageBean);
        this.settingPageBean = settingPageBean;
    }

    private final void ja() {
        this.spaceSettingList.clear();
        List<com.qzone.reborn.albumx.common.bean.i> list = this.spaceSettingList;
        String a16 = com.qzone.util.l.a(R.string.v8s);
        Intrinsics.checkNotNullExpressionValue(a16, "qqStr(R.string.qzone_int\u2026_change_space_permission)");
        list.add(J9(a16, T9(), false));
        QZIntimateSettingPageBean qZIntimateSettingPageBean = this.settingPageBean;
        QZIntimateSettingPageBean qZIntimateSettingPageBean2 = null;
        if (qZIntimateSettingPageBean == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingPageBean");
            qZIntimateSettingPageBean = null;
        }
        if (qZIntimateSettingPageBean.getSupportModifyAnniversary()) {
            List<com.qzone.reborn.albumx.common.bean.i> list2 = this.spaceSettingList;
            String a17 = com.qzone.util.l.a(R.string.w_b);
            Intrinsics.checkNotNullExpressionValue(a17, "qqStr(R.string.qzone_modify_anniversary)");
            list2.add(J9(a17, "", false));
        }
        QZIntimateSettingPageBean qZIntimateSettingPageBean3 = this.settingPageBean;
        if (qZIntimateSettingPageBean3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingPageBean");
            qZIntimateSettingPageBean3 = null;
        }
        if (qZIntimateSettingPageBean3.getIsEnableSyncQZoneAlbum()) {
            List<com.qzone.reborn.albumx.common.bean.i> list3 = this.spaceSettingList;
            String a18 = com.qzone.util.l.a(R.string.w9v);
            Intrinsics.checkNotNullExpressionValue(a18, "qqStr(R.string.qzone_intimate_sync_album_data)");
            list3.add(J9(a18, "", false));
        }
        QZIntimateSettingPageBean qZIntimateSettingPageBean4 = this.settingPageBean;
        if (qZIntimateSettingPageBean4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingPageBean");
        } else {
            qZIntimateSettingPageBean2 = qZIntimateSettingPageBean4;
        }
        if (qZIntimateSettingPageBean2.getIsNeedShowSyncLoverSpaceEntrance()) {
            List<com.qzone.reborn.albumx.common.bean.i> list4 = this.spaceSettingList;
            String a19 = com.qzone.util.l.a(R.string.w9y);
            Intrinsics.checkNotNullExpressionValue(a19, "qqStr(R.string.qzone_intimate_transfer_data_guide)");
            list4.add(J9(a19, "", false));
        }
    }

    private final void la() {
        ck.c o16 = ho.i.o();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        QZoneIntimateAlbumSyncInitBean qZoneIntimateAlbumSyncInitBean = new QZoneIntimateAlbumSyncInitBean();
        QZIntimateSettingPageBean qZIntimateSettingPageBean = this.settingPageBean;
        if (qZIntimateSettingPageBean == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingPageBean");
            qZIntimateSettingPageBean = null;
        }
        qZoneIntimateAlbumSyncInitBean.setSpaceId(qZIntimateSettingPageBean.getSpaceId());
        String a16 = com.qzone.util.l.a(R.string.v7g);
        Intrinsics.checkNotNullExpressionValue(a16, "qqStr(R.string.qzone_int\u2026te_album_sync_title_text)");
        qZoneIntimateAlbumSyncInitBean.setTitle(a16);
        Unit unit = Unit.INSTANCE;
        o16.l(context, qZoneIntimateAlbumSyncInitBean);
        fo.c.e("em_qz_sync_my_space_album_entry", "pg_qz_settings_page_buddy", getPartRootView(), null);
    }

    private final void ma() {
        QZIntimateSettingPageBean qZIntimateSettingPageBean = this.settingPageBean;
        QZIntimateSettingPageBean qZIntimateSettingPageBean2 = null;
        if (qZIntimateSettingPageBean == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingPageBean");
            qZIntimateSettingPageBean = null;
        }
        if (TextUtils.isEmpty(qZIntimateSettingPageBean.getSpaceId())) {
            return;
        }
        QZIntimateSettingPageBean qZIntimateSettingPageBean3 = this.settingPageBean;
        if (qZIntimateSettingPageBean3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingPageBean");
            qZIntimateSettingPageBean3 = null;
        }
        if (TextUtils.isEmpty(qZIntimateSettingPageBean3.getMigrateAuthUrl())) {
            return;
        }
        fo.c.e("em_qz_sync_old_couple_space_entry", "pg_qz_settings_page_buddy", getPartRootView(), null);
        QZIntimateSettingPageBean qZIntimateSettingPageBean4 = this.settingPageBean;
        if (qZIntimateSettingPageBean4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingPageBean");
            qZIntimateSettingPageBean4 = null;
        }
        String migrateAuthUrl = qZIntimateSettingPageBean4.getMigrateAuthUrl();
        QZIntimateSettingPageBean qZIntimateSettingPageBean5 = this.settingPageBean;
        if (qZIntimateSettingPageBean5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingPageBean");
        } else {
            qZIntimateSettingPageBean2 = qZIntimateSettingPageBean5;
        }
        ho.i.q(getContext(), migrateAuthUrl + "&space_id=" + qZIntimateSettingPageBean2.getSpaceId());
    }

    private final void na() {
        if (com.qzone.reborn.util.e.b("QZoneIntimateManageTitlePartHalfScreen", 500L)) {
            return;
        }
        ck.c o16 = ho.i.o();
        Activity activity = getActivity();
        QZIntimateSettingPageBean qZIntimateSettingPageBean = this.settingPageBean;
        if (qZIntimateSettingPageBean == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingPageBean");
            qZIntimateSettingPageBean = null;
        }
        o16.h(activity, qZIntimateSettingPageBean.getSpaceId());
        fo.c.c("em_qz_modify_the_intimate_space_permission_button_clck", null);
    }

    private final void oa() {
        QZIntimateSettingPageBean qZIntimateSettingPageBean = this.settingPageBean;
        QZIntimateSettingPageBean qZIntimateSettingPageBean2 = null;
        if (qZIntimateSettingPageBean == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingPageBean");
            qZIntimateSettingPageBean = null;
        }
        if (qZIntimateSettingPageBean.getSupportModifyAnniversary()) {
            QZIntimateSettingPageBean qZIntimateSettingPageBean3 = this.settingPageBean;
            if (qZIntimateSettingPageBean3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("settingPageBean");
            } else {
                qZIntimateSettingPageBean2 = qZIntimateSettingPageBean3;
            }
            long anniversary = qZIntimateSettingPageBean2.getAnniversary() * 1000;
            String title = com.qzone.util.l.a(R.string.wbn);
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            Intrinsics.checkNotNullExpressionValue(title, "title");
            com.qzone.reborn.widget.g gVar = new com.qzone.reborn.widget.g(context, title);
            gVar.M(anniversary);
            gVar.i(new d(gVar));
            if (gVar.L() != null) {
                fo.c.m(gVar.L(), "pg_qz_couple_anniversary_revision");
            }
            gVar.m();
        }
    }

    private final boolean pa(String settingKey) {
        Object obj;
        QZIntimateSettingPageBean qZIntimateSettingPageBean = this.settingPageBean;
        if (qZIntimateSettingPageBean == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingPageBean");
            qZIntimateSettingPageBean = null;
        }
        Iterator<T> it = qZIntimateSettingPageBean.getSettingList().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (TextUtils.equals(settingKey, ((QZIntimateSettingItemBean) obj).getKey())) {
                break;
            }
        }
        QZIntimateSettingItemBean qZIntimateSettingItemBean = (QZIntimateSettingItemBean) obj;
        return TextUtils.equals(qZIntimateSettingItemBean != null ? qZIntimateSettingItemBean.getValue() : null, "true");
    }

    private final void qa() {
        ea();
        ia();
        ba();
        QUSHalfScreenImmersiveFloatingView qUSHalfScreenImmersiveFloatingView = this.settingMenu;
        if ((qUSHalfScreenImmersiveFloatingView != null ? qUSHalfScreenImmersiveFloatingView.getParent() : null) == null) {
            View partRootView = getPartRootView();
            Intrinsics.checkNotNull(partRootView, "null cannot be cast to non-null type android.view.ViewGroup");
            ((ViewGroup) partRootView).addView(this.settingMenu);
        }
        QUSHalfScreenImmersiveFloatingView qUSHalfScreenImmersiveFloatingView2 = this.settingMenu;
        if (qUSHalfScreenImmersiveFloatingView2 != null) {
            qUSHalfScreenImmersiveFloatingView2.N(0);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        initViewModel();
        qa();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        super.onPartResume(activity);
        da();
    }

    private final void V9(boolean isOpen) {
        if (isOpen) {
            broadcastMessage("INTIMATE_SHOW_CHECK_IN_REMIND_DIALOG", null);
        }
        fo.c.e("em_qz_couple_space_punch_remind_switch", "pg_qz_settings_page_buddy", getPartRootView(), S9(isOpen));
    }

    private final void P9(String leftText) {
        if (Intrinsics.areEqual(leftText, com.qzone.util.l.a(R.string.v8s))) {
            na();
            return;
        }
        if (Intrinsics.areEqual(leftText, com.qzone.util.l.a(R.string.w_b))) {
            oa();
        } else if (Intrinsics.areEqual(leftText, com.qzone.util.l.a(R.string.w9y))) {
            ma();
        } else if (Intrinsics.areEqual(leftText, com.qzone.util.l.a(R.string.w9v))) {
            la();
        }
    }

    private final String U9(String leftText) {
        if (Intrinsics.areEqual(leftText, com.qzone.util.l.a(R.string.v8u))) {
            return "sync_qzone_switch";
        }
        if (Intrinsics.areEqual(leftText, com.qzone.util.l.a(R.string.v8t))) {
            return "sync_friend_switch";
        }
        if (Intrinsics.areEqual(leftText, com.qzone.util.l.a(R.string.v8v))) {
            return "signin_notice_switch";
        }
        return "";
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/qzone/reborn/intimate/part/bb$d", "Lcom/tencent/mobileqq/widget/selectorview/QActionSheet$f;", "", "onDismiss", "t", "onConfirm", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class d implements QActionSheet.f {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.qzone.reborn.widget.g f57421d;

        d(com.qzone.reborn.widget.g gVar) {
            this.f57421d = gVar;
        }

        @Override // com.tencent.mobileqq.widget.selectorview.QActionSheet.f
        public void onConfirm() {
            SimpleEventBus.getInstance().dispatchEvent(new QZIntimateModifyAnniversaryEvent(this.f57421d.K() / 1000));
            fo.c.c("ev_qz_anniversary_modification_confirmation_button_clck", null);
        }

        @Override // com.tencent.mobileqq.widget.selectorview.QActionSheet.f
        public void onDismiss() {
        }

        @Override // com.tencent.mobileqq.widget.selectorview.QActionSheet.f
        public void t() {
        }
    }
}
