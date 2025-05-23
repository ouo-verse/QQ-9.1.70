package com.tencent.mobileqq.zootopia.permission;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.zootopia.permission.SmallHomePermissionManagerFragment;
import com.tencent.mobileqq.zootopia.view.ZootopiaFormMutilItem;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QzoneIPCModule;
import hw4.t;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.MobileQQ;

@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u0000 \\2\u00020\u0001:\u0004]^_`B\u0007\u00a2\u0006\u0004\bZ\u0010[J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u001a\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\fH\u0002J\u001a\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\nH\u0002J\"\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0016\u001a\u00020\nH\u0002J\u0018\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\nH\u0002J\u0010\u0010\u001b\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\nH\u0002J\b\u0010\u001c\u001a\u00020\u0002H\u0002J\b\u0010\u001d\u001a\u00020\u0002H\u0002J\u0010\u0010 \u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u001eH\u0002J\u0010\u0010\"\u001a\u00020\u00022\u0006\u0010!\u001a\u00020\u001eH\u0002J\u001a\u0010$\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010#\u001a\u0004\u0018\u00010\u0014H\u0002J\u0010\u0010&\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020%H\u0002J\u0012\u0010(\u001a\u0004\u0018\u00010\n2\u0006\u0010'\u001a\u00020\u0012H\u0002J\u0019\u0010*\u001a\u0004\u0018\u00010\u00122\u0006\u0010)\u001a\u00020\nH\u0002\u00a2\u0006\u0004\b*\u0010+J\b\u0010,\u001a\u00020\fH\u0002J\u0010\u0010.\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020-H\u0002J\u0010\u0010/\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002J&\u00105\u001a\u00020\u00022\b\u00101\u001a\u0004\u0018\u0001002\b\u0010\u0007\u001a\u0004\u0018\u0001022\b\u00104\u001a\u0004\u0018\u000103H\u0014J\u001a\u00108\u001a\u00020\u00022\u0006\u00107\u001a\u0002062\b\u00104\u001a\u0004\u0018\u000103H\u0016J\b\u00109\u001a\u00020\u0012H\u0014J\"\u0010>\u001a\u00020\u00022\u0006\u0010:\u001a\u00020\u00122\u0006\u0010;\u001a\u00020\u00122\b\u0010=\u001a\u0004\u0018\u00010<H\u0016J\b\u0010?\u001a\u00020\u0002H\u0016R\u0018\u0010B\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0018\u0010E\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u0018\u0010G\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010AR0\u0010M\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020I0Hj\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020I`J8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bK\u0010LR\u0018\u0010Q\u001a\u0004\u0018\u00010N8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bO\u0010PR\u0016\u0010T\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bR\u0010SR\u0018\u0010W\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bU\u0010VR\u0018\u0010Y\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bX\u0010V\u00a8\u0006a"}, d2 = {"Lcom/tencent/mobileqq/zootopia/permission/SmallHomePermissionManagerFragment;", "Lcom/tencent/mobileqq/fragment/QIphoneTitleBarFragment;", "", "yh", "initData", "initView", "Landroid/widget/FrameLayout;", ParseCommon.CONTAINER, "Kh", "Fh", "Lcom/tencent/mobileqq/zootopia/permission/SmallHomePermissionManagerFragment$ItemType;", "type", "", "needReport", "Wh", "Rh", "newType", "Bh", "", "error", "", "msg", "configType", "Nh", "Lhw4/t;", "result", "Oh", OcrConfig.CHINESE, "Ch", "Qh", "Lcom/tencent/mobileqq/zootopia/permission/SmallHomePermissionManagerFragment$State;", "newState", "Th", "state", "Vh", "message", "Lh", "Lhw4/p;", "Mh", "status", "Dh", "itemType", "Eh", "(Lcom/tencent/mobileqq/zootopia/permission/SmallHomePermissionManagerFragment$ItemType;)Ljava/lang/Integer;", "Ah", "Landroid/widget/LinearLayout;", "Hh", "Ph", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "doOnCreateView", "Landroid/view/View;", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "getContentLayoutId", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", MosaicConstants$JsFunction.FUNC_ON_DESTROY, BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/FrameLayout;", "containerView", "D", "Landroid/widget/LinearLayout;", "itemContainerView", "E", "errorView", "Ljava/util/HashMap;", "Lcom/tencent/mobileqq/zootopia/permission/SmallHomePermissionManagerFragment$b;", "Lkotlin/collections/HashMap;", UserInfo.SEX_FEMALE, "Ljava/util/HashMap;", "itemMap", "Lid3/d;", "G", "Lid3/d;", "reportHelper", "H", "Lcom/tencent/mobileqq/zootopia/permission/SmallHomePermissionManagerFragment$State;", "curState", "I", "Lcom/tencent/mobileqq/zootopia/permission/SmallHomePermissionManagerFragment$ItemType;", "curItemType", "J", "configuringItemType", "<init>", "()V", "K", "a", "b", "ItemType", "State", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class SmallHomePermissionManagerFragment extends QIphoneTitleBarFragment {

    /* renamed from: C, reason: from kotlin metadata */
    private FrameLayout containerView;

    /* renamed from: D, reason: from kotlin metadata */
    private LinearLayout itemContainerView;

    /* renamed from: E, reason: from kotlin metadata */
    private FrameLayout errorView;

    /* renamed from: F, reason: from kotlin metadata */
    private final HashMap<ItemType, ItemInfo> itemMap;

    /* renamed from: G, reason: from kotlin metadata */
    private id3.d reportHelper;

    /* renamed from: H, reason: from kotlin metadata */
    private volatile State curState;

    /* renamed from: I, reason: from kotlin metadata */
    private ItemType curItemType;

    /* renamed from: J, reason: from kotlin metadata */
    private ItemType configuringItemType;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/zootopia/permission/SmallHomePermissionManagerFragment$ItemType;", "", "(Ljava/lang/String;I)V", "UNKNOW", "ALL", "FRIENDS", "SELF", "SELECT_FRIENDS", "BLACK_LIST", "zplan_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes35.dex */
    public enum ItemType {
        UNKNOW,
        ALL,
        FRIENDS,
        SELF,
        SELECT_FRIENDS,
        BLACK_LIST
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/zootopia/permission/SmallHomePermissionManagerFragment$State;", "", "(Ljava/lang/String;I)V", "NONE", "INIT_VIEW", "GET_CONFIG_FROM_SERVER_ING", "GET_CONFIG_FROM_SERVER_FAILED", "GET_CONFIG_FROM_SERVER_SUCCESS", "CHANGE_CONFIG_ING", "CHANGE_CONFIG_FAILED", "CHANGE_CONFIG_SUCCESS", "zplan_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes35.dex */
    public enum State {
        NONE,
        INIT_VIEW,
        GET_CONFIG_FROM_SERVER_ING,
        GET_CONFIG_FROM_SERVER_FAILED,
        GET_CONFIG_FROM_SERVER_SUCCESS,
        CHANGE_CONFIG_ING,
        CHANGE_CONFIG_FAILED,
        CHANGE_CONFIG_SUCCESS
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes35.dex */
    public /* synthetic */ class c {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f328630a;

        static {
            int[] iArr = new int[ItemType.values().length];
            try {
                iArr[ItemType.ALL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ItemType.FRIENDS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ItemType.SELF.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ItemType.SELECT_FRIENDS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f328630a = iArr;
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/zootopia/permission/SmallHomePermissionManagerFragment$d", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lhw4/t;", "result", "", "d", "", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class d implements com.tencent.mobileqq.zootopia.api.e<t> {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ItemType f328632e;

        d(ItemType itemType) {
            this.f328632e = itemType;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(SmallHomePermissionManagerFragment this$0, int i3, String str, ItemType newType) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(newType, "$newType");
            this$0.Nh(i3, str, newType);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void e(SmallHomePermissionManagerFragment this$0, t result, ItemType newType) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(result, "$result");
            Intrinsics.checkNotNullParameter(newType, "$newType");
            this$0.Oh(result, newType);
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(final t result) {
            Intrinsics.checkNotNullParameter(result, "result");
            FragmentActivity activity = SmallHomePermissionManagerFragment.this.getActivity();
            if (activity != null) {
                final SmallHomePermissionManagerFragment smallHomePermissionManagerFragment = SmallHomePermissionManagerFragment.this;
                final ItemType itemType = this.f328632e;
                activity.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.zootopia.permission.n
                    @Override // java.lang.Runnable
                    public final void run() {
                        SmallHomePermissionManagerFragment.d.e(SmallHomePermissionManagerFragment.this, result, itemType);
                    }
                });
            }
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(final int error, final String message) {
            FragmentActivity activity = SmallHomePermissionManagerFragment.this.getActivity();
            if (activity != null) {
                final SmallHomePermissionManagerFragment smallHomePermissionManagerFragment = SmallHomePermissionManagerFragment.this;
                final ItemType itemType = this.f328632e;
                activity.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.zootopia.permission.o
                    @Override // java.lang.Runnable
                    public final void run() {
                        SmallHomePermissionManagerFragment.d.c(SmallHomePermissionManagerFragment.this, error, message, itemType);
                    }
                });
            }
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/zootopia/permission/SmallHomePermissionManagerFragment$e", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lhw4/p;", "result", "", "d", "", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class e implements com.tencent.mobileqq.zootopia.api.e<hw4.p> {
        e() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(SmallHomePermissionManagerFragment this$0, int i3, String str) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.Lh(i3, str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void e(SmallHomePermissionManagerFragment this$0, hw4.p result) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(result, "$result");
            this$0.Mh(result);
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(final hw4.p result) {
            Intrinsics.checkNotNullParameter(result, "result");
            FragmentActivity activity = SmallHomePermissionManagerFragment.this.getActivity();
            if (activity != null) {
                final SmallHomePermissionManagerFragment smallHomePermissionManagerFragment = SmallHomePermissionManagerFragment.this;
                activity.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.zootopia.permission.p
                    @Override // java.lang.Runnable
                    public final void run() {
                        SmallHomePermissionManagerFragment.e.e(SmallHomePermissionManagerFragment.this, result);
                    }
                });
            }
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(final int error, final String message) {
            FragmentActivity activity = SmallHomePermissionManagerFragment.this.getActivity();
            if (activity != null) {
                final SmallHomePermissionManagerFragment smallHomePermissionManagerFragment = SmallHomePermissionManagerFragment.this;
                activity.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.zootopia.permission.q
                    @Override // java.lang.Runnable
                    public final void run() {
                        SmallHomePermissionManagerFragment.e.c(SmallHomePermissionManagerFragment.this, error, message);
                    }
                });
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\t\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/zootopia/permission/SmallHomePermissionManagerFragment$f", "Lcom/tencent/mobileqq/zootopia/api/e;", "", "result", "", "a", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class f implements com.tencent.mobileqq.zootopia.api.e<Integer> {
        f() {
        }

        public void a(int result) {
            ZootopiaFormMutilItem itemView;
            ItemInfo itemInfo = (ItemInfo) SmallHomePermissionManagerFragment.this.itemMap.get(ItemType.SELECT_FRIENDS);
            if (itemInfo == null || (itemView = itemInfo.getItemView()) == null) {
                return;
            }
            itemView.setSecondLineText("\u9009\u4e2d\u7684\u4eba\u53ef\u8fdb " + result + "\u4eba ", R.drawable.common_arrow_right_selector);
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            QLog.e("SmallHomePermissionManagerFragment", 1, "refresh white list FriendCount err:" + error + ", msg:" + message);
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public /* bridge */ /* synthetic */ void onResultSuccess(Integer num) {
            a(num.intValue());
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\t\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/zootopia/permission/SmallHomePermissionManagerFragment$g", "Lcom/tencent/mobileqq/zootopia/api/e;", "", "result", "", "a", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class g implements com.tencent.mobileqq.zootopia.api.e<Integer> {
        g() {
        }

        public void a(int result) {
            ZootopiaFormMutilItem itemView;
            ItemInfo itemInfo = (ItemInfo) SmallHomePermissionManagerFragment.this.itemMap.get(ItemType.BLACK_LIST);
            if (itemInfo == null || (itemView = itemInfo.getItemView()) == null) {
                return;
            }
            itemView.setRightText(result + "\u4eba");
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            QLog.e("SmallHomePermissionManagerFragment", 1, "refresh black list FriendCount err:" + error + ", msg:" + message);
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public /* bridge */ /* synthetic */ void onResultSuccess(Integer num) {
            a(num.intValue());
        }
    }

    public SmallHomePermissionManagerFragment() {
        HashMap<ItemType, ItemInfo> hashMap = new HashMap<>();
        ItemType itemType = ItemType.ALL;
        hashMap.put(itemType, new ItemInfo(itemType, R.id.pvq, false, 4, null));
        ItemType itemType2 = ItemType.FRIENDS;
        boolean z16 = false;
        int i3 = 4;
        DefaultConstructorMarker defaultConstructorMarker = null;
        hashMap.put(itemType2, new ItemInfo(itemType2, R.id.pvs, z16, i3, defaultConstructorMarker));
        ItemType itemType3 = ItemType.SELF;
        hashMap.put(itemType3, new ItemInfo(itemType3, R.id.pvu, false, 4, null));
        ItemType itemType4 = ItemType.SELECT_FRIENDS;
        hashMap.put(itemType4, new ItemInfo(itemType4, R.id.pvt, z16, i3, defaultConstructorMarker));
        ItemType itemType5 = ItemType.BLACK_LIST;
        hashMap.put(itemType5, new ItemInfo(itemType5, R.id.pvr, true));
        this.itemMap = hashMap;
        this.curState = State.NONE;
    }

    private final boolean Ah() {
        return this.curState == State.INIT_VIEW || this.curState == State.GET_CONFIG_FROM_SERVER_FAILED;
    }

    private final void Bh(ItemType newType) {
        State state = this.curState;
        State state2 = State.CHANGE_CONFIG_ING;
        int i3 = 0;
        if (state == state2) {
            QQToast.makeText(MobileQQ.sMobileQQ, "\u64cd\u4f5c\u8fc7\u5feb\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5", 0).show();
            return;
        }
        if (zh(newType)) {
            Th(state2);
            DefaultConstructorMarker defaultConstructorMarker = null;
            Sh(this, newType, false, 2, null);
            this.configuringItemType = newType;
            AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
            AppInterface appInterface = waitAppRuntime instanceof AppInterface ? (AppInterface) waitAppRuntime : null;
            if (appInterface == null) {
                Nh(-1, "app is null", newType);
                return;
            }
            Integer Eh = Eh(newType);
            if (Eh == null) {
                Nh(-1, "unknow requestType", newType);
            } else {
                new com.tencent.mobileqq.zootopia.service.j(i3, 1, defaultConstructorMarker).m(appInterface, Eh.intValue(), new d(newType));
            }
        }
    }

    private final void Ch() {
        if (Ah()) {
            Th(State.GET_CONFIG_FROM_SERVER_ING);
            DefaultConstructorMarker defaultConstructorMarker = null;
            AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
            AppInterface appInterface = waitAppRuntime instanceof AppInterface ? (AppInterface) waitAppRuntime : null;
            if (appInterface == null) {
                Lh(-1, "app is null");
            } else {
                new com.tencent.mobileqq.zootopia.service.j(0, 1, defaultConstructorMarker).f(appInterface, new e());
            }
        }
    }

    private final Integer Eh(ItemType itemType) {
        int i3 = c.f328630a[itemType.ordinal()];
        if (i3 == 1) {
            return 1;
        }
        if (i3 == 2) {
            return 2;
        }
        if (i3 != 3) {
            return i3 != 4 ? null : 4;
        }
        return 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Gh(SmallHomePermissionManagerFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.initData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ih(ItemType type, SmallHomePermissionManagerFragment this$0, ZootopiaFormMutilItem this_apply, View it) {
        Intrinsics.checkNotNullParameter(type, "$type");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        if (type == ItemType.BLACK_LIST) {
            this$0.Ph(type);
            id3.d dVar = this$0.reportHelper;
            if (dVar != null) {
                dVar.c("clck", this_apply, new LinkedHashMap());
                return;
            }
            return;
        }
        this$0.Bh(type);
        id3.d dVar2 = this$0.reportHelper;
        if (dVar2 != null) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("zplan_xiaowo_permit_general_status", String.valueOf(type.ordinal()));
            Unit unit = Unit.INSTANCE;
            dVar2.c("clck", it, linkedHashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Jh(SmallHomePermissionManagerFragment this$0, ItemType type, ZootopiaFormMutilItem this_apply, View view) {
        id3.d dVar;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(type, "$type");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        this$0.Ph(type);
        View k3 = this_apply.k();
        if (k3 == null || (dVar = this$0.reportHelper) == null) {
            return;
        }
        dVar.c("clck", k3, new LinkedHashMap());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Lh(int error, String message) {
        QLog.e("SmallHomePermissionManagerFragment", 1, "onGetConfigFailed, " + error + ", " + message);
        Th(State.GET_CONFIG_FROM_SERVER_FAILED);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Mh(hw4.p result) {
        ItemType Dh = Dh(result.f406534a);
        if (Dh == null) {
            Lh(-1, "covert status error:" + result.f406534a);
            return;
        }
        Wh(Dh, true);
        Th(State.GET_CONFIG_FROM_SERVER_SUCCESS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Nh(int error, String msg2, ItemType configType) {
        if (this.configuringItemType != configType) {
            return;
        }
        QLog.e("SmallHomePermissionManagerFragment", 1, "onSetConfigFailed:" + error + ", " + msg2 + ", " + configType.name());
        QQToast.makeText(MobileQQ.sMobileQQ, "\u8bbe\u7f6e\u5931\u8d25", 0).show();
        Th(State.CHANGE_CONFIG_FAILED);
        ItemType itemType = this.curItemType;
        if (itemType != null) {
            Sh(this, itemType, false, 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Oh(t result, ItemType configType) {
        if (this.configuringItemType != configType) {
            return;
        }
        Th(State.CHANGE_CONFIG_SUCCESS);
        Xh(this, configType, false, 2, null);
    }

    private final void Ph(ItemType type) {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putInt("param_item_type", type.ordinal());
        intent.putExtras(bundle);
        QPublicFragmentActivity.startForResult(this, intent, (Class<? extends QPublicBaseFragment>) SmallHomeOprFriendFragment.class, 381);
    }

    private final void Qh() {
        DefaultConstructorMarker defaultConstructorMarker = null;
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        AppInterface appInterface = waitAppRuntime instanceof AppInterface ? (AppInterface) waitAppRuntime : null;
        int i3 = 1;
        if (appInterface == null) {
            QLog.e("SmallHomePermissionManagerFragment", 1, "refreshFriendCount app is null");
            return;
        }
        int i16 = 0;
        new com.tencent.mobileqq.zootopia.service.j(i16, i3, defaultConstructorMarker).i(appInterface, 1, new f());
        new com.tencent.mobileqq.zootopia.service.j(i16, i3, defaultConstructorMarker).i(appInterface, 2, new g());
    }

    private final void Rh(ItemType type, boolean needReport) {
        id3.d dVar;
        Iterator<Map.Entry<ItemType, ItemInfo>> it = this.itemMap.entrySet().iterator();
        while (it.hasNext()) {
            ItemInfo value = it.next().getValue();
            value.g(value.getItemType() == type);
            ZootopiaFormMutilItem itemView = value.getItemView();
            if (itemView != null) {
                itemView.setIsSelected(value.getSelected());
                if (needReport && value.getSelected() && (dVar = this.reportHelper) != null) {
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    linkedHashMap.put("zplan_xiaowo_permit_general_status", String.valueOf(type.ordinal()));
                    Unit unit = Unit.INSTANCE;
                    dVar.c("imp", itemView, linkedHashMap);
                }
            }
        }
    }

    private final void Th(final State newState) {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.zootopia.permission.m
                @Override // java.lang.Runnable
                public final void run() {
                    SmallHomePermissionManagerFragment.Uh(SmallHomePermissionManagerFragment.this, newState);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Uh(SmallHomePermissionManagerFragment this$0, State newState) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(newState, "$newState");
        this$0.curState = newState;
        this$0.Vh(newState);
    }

    private final void Vh(State state) {
        String str;
        State state2 = State.GET_CONFIG_FROM_SERVER_FAILED;
        if (state == state2) {
            str = "\u52a0\u8f7d\u5931\u8d25";
        } else {
            str = "\u8c01\u53ef\u4ee5\u8fdb";
        }
        setTitle(str);
        LinearLayout linearLayout = this.itemContainerView;
        if (linearLayout != null) {
            linearLayout.setVisibility(state.ordinal() >= State.GET_CONFIG_FROM_SERVER_SUCCESS.ordinal() ? 0 : 8);
        }
        FrameLayout frameLayout = this.errorView;
        if (frameLayout == null) {
            return;
        }
        frameLayout.setVisibility(state != state2 ? 8 : 0);
    }

    private final void Wh(ItemType type, boolean needReport) {
        this.curItemType = type;
        Rh(type, needReport);
    }

    private final void initData() {
        Ch();
        Qh();
    }

    private final void initView() {
        View view = ((QIphoneTitleBarFragment) this).mContentView;
        FrameLayout frameLayout = view != null ? (FrameLayout) view.findViewById(R.id.r1v) : null;
        FrameLayout frameLayout2 = frameLayout instanceof FrameLayout ? frameLayout : null;
        if (frameLayout2 == null) {
            return;
        }
        this.containerView = frameLayout2;
        Kh(frameLayout2);
        Fh(frameLayout2);
        Th(State.INIT_VIEW);
    }

    private final void yh() {
        ZootopiaFormMutilItem itemView;
        id3.d dVar;
        for (Map.Entry<ItemType, ItemInfo> entry : this.itemMap.entrySet()) {
            if (entry.getKey() != ItemType.BLACK_LIST && (itemView = entry.getValue().getItemView()) != null && (dVar = this.reportHelper) != null) {
                id3.d.i(dVar, itemView, "em_zplan_xiaowo_permit_general", new LinkedHashMap(), false, true, null, false, false, 224, null);
            }
        }
    }

    private final boolean zh(ItemType newType) {
        return (this.curItemType == newType || this.curState == State.CHANGE_CONFIG_ING || this.curState.ordinal() < State.GET_CONFIG_FROM_SERVER_SUCCESS.ordinal()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public void doOnCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.doOnCreateView(inflater, container, savedInstanceState);
        this.reportHelper = new id3.d(null, 1, null);
        initView();
        initData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.d9g;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 381 && resultCode == -1) {
            Qh();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.reportHelper = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        id3.d dVar;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        FrameLayout frameLayout = this.containerView;
        if (frameLayout != null && (dVar = this.reportHelper) != null) {
            FragmentActivity requireActivity = requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            dVar.j(requireActivity, frameLayout, "pg_zplan_xiaowo_permit", new LinkedHashMap());
        }
        yh();
    }

    private final void Hh(LinearLayout container) {
        id3.d dVar;
        for (Map.Entry<ItemType, ItemInfo> entry : this.itemMap.entrySet()) {
            ItemInfo value = entry.getValue();
            final ItemType key = entry.getKey();
            value.f((ZootopiaFormMutilItem) container.findViewById(value.getFormId()));
            final ZootopiaFormMutilItem itemView = value.getItemView();
            if (itemView != null) {
                itemView.h(value.getNeedRightArrow());
                itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zootopia.permission.j
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        SmallHomePermissionManagerFragment.Ih(SmallHomePermissionManagerFragment.ItemType.this, this, itemView, view);
                    }
                });
                itemView.setIsSelected(value.getSelected());
                if (key == ItemType.BLACK_LIST) {
                    id3.d dVar2 = this.reportHelper;
                    if (dVar2 != null) {
                        id3.d.h(dVar2, itemView, "em_zplan_xiaowo_permit_blacklist", new LinkedHashMap(), false, false, null, 56, null);
                    }
                } else if (key == ItemType.SELECT_FRIENDS) {
                    itemView.setSecondTextClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zootopia.permission.k
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            SmallHomePermissionManagerFragment.Jh(SmallHomePermissionManagerFragment.this, key, itemView, view);
                        }
                    });
                    View k3 = itemView.k();
                    if (k3 != null && (dVar = this.reportHelper) != null) {
                        id3.d.h(dVar, k3, "em_zplan_xiaowo_permit_selected", new LinkedHashMap(), false, false, null, 56, null);
                    }
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0011\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0007\u00a2\u0006\u0004\b!\u0010\"J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0011\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u000f\u001a\u0004\b\n\u0010\u0010R\u0017\u0010\u0016\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R$\u0010\u001c\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0018\u001a\u0004\b\u0012\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010 \u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u0013\u001a\u0004\b\u001d\u0010\u0015\"\u0004\b\u001e\u0010\u001f\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/zootopia/permission/SmallHomePermissionManagerFragment$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/mobileqq/zootopia/permission/SmallHomePermissionManagerFragment$ItemType;", "a", "Lcom/tencent/mobileqq/zootopia/permission/SmallHomePermissionManagerFragment$ItemType;", "b", "()Lcom/tencent/mobileqq/zootopia/permission/SmallHomePermissionManagerFragment$ItemType;", "itemType", "I", "()I", "formId", "c", "Z", "d", "()Z", "needRightArrow", "Lcom/tencent/mobileqq/zootopia/view/ZootopiaFormMutilItem;", "Lcom/tencent/mobileqq/zootopia/view/ZootopiaFormMutilItem;", "()Lcom/tencent/mobileqq/zootopia/view/ZootopiaFormMutilItem;", "f", "(Lcom/tencent/mobileqq/zootopia/view/ZootopiaFormMutilItem;)V", "itemView", "e", "g", "(Z)V", "selected", "<init>", "(Lcom/tencent/mobileqq/zootopia/permission/SmallHomePermissionManagerFragment$ItemType;IZ)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zootopia.permission.SmallHomePermissionManagerFragment$b, reason: from toString */
    /* loaded from: classes35.dex */
    public static final /* data */ class ItemInfo {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final ItemType itemType;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final int formId;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean needRightArrow;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private ZootopiaFormMutilItem itemView;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private boolean selected;

        public ItemInfo(ItemType itemType, int i3, boolean z16) {
            Intrinsics.checkNotNullParameter(itemType, "itemType");
            this.itemType = itemType;
            this.formId = i3;
            this.needRightArrow = z16;
        }

        /* renamed from: a, reason: from getter */
        public final int getFormId() {
            return this.formId;
        }

        /* renamed from: b, reason: from getter */
        public final ItemType getItemType() {
            return this.itemType;
        }

        /* renamed from: c, reason: from getter */
        public final ZootopiaFormMutilItem getItemView() {
            return this.itemView;
        }

        /* renamed from: d, reason: from getter */
        public final boolean getNeedRightArrow() {
            return this.needRightArrow;
        }

        /* renamed from: e, reason: from getter */
        public final boolean getSelected() {
            return this.selected;
        }

        public final void f(ZootopiaFormMutilItem zootopiaFormMutilItem) {
            this.itemView = zootopiaFormMutilItem;
        }

        public final void g(boolean z16) {
            this.selected = z16;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode = ((this.itemType.hashCode() * 31) + this.formId) * 31;
            boolean z16 = this.needRightArrow;
            int i3 = z16;
            if (z16 != 0) {
                i3 = 1;
            }
            return hashCode + i3;
        }

        public String toString() {
            return "ItemInfo(itemType=" + this.itemType + ", formId=" + this.formId + ", needRightArrow=" + this.needRightArrow + ")";
        }

        public /* synthetic */ ItemInfo(ItemType itemType, int i3, boolean z16, int i16, DefaultConstructorMarker defaultConstructorMarker) {
            this(itemType, i3, (i16 & 4) != 0 ? false : z16);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ItemInfo)) {
                return false;
            }
            ItemInfo itemInfo = (ItemInfo) other;
            return this.itemType == itemInfo.itemType && this.formId == itemInfo.formId && this.needRightArrow == itemInfo.needRightArrow;
        }
    }

    private final void Fh(FrameLayout container) {
        View findViewById = container.findViewById(R.id.r1y);
        FrameLayout frameLayout = findViewById instanceof FrameLayout ? (FrameLayout) findViewById : null;
        if (frameLayout != null) {
            this.errorView = frameLayout;
            ImageView imageView = (ImageView) frameLayout.findViewById(R.id.r1w);
            if (imageView != null) {
                imageView.setImageResource(R.drawable.dqb);
            }
            TextView textView = (TextView) frameLayout.findViewById(R.id.r1x);
            if (textView != null) {
                textView.setText(R.string.pyp);
            }
            frameLayout.setVisibility(8);
            frameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zootopia.permission.l
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SmallHomePermissionManagerFragment.Gh(SmallHomePermissionManagerFragment.this, view);
                }
            });
        }
    }

    private final void Kh(FrameLayout container) {
        View findViewById = container.findViewById(R.id.r1z);
        LinearLayout linearLayout = findViewById instanceof LinearLayout ? (LinearLayout) findViewById : null;
        if (linearLayout != null) {
            this.itemContainerView = linearLayout;
            Hh(linearLayout);
            linearLayout.setVisibility(8);
        }
    }

    static /* synthetic */ void Sh(SmallHomePermissionManagerFragment smallHomePermissionManagerFragment, ItemType itemType, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        smallHomePermissionManagerFragment.Rh(itemType, z16);
    }

    static /* synthetic */ void Xh(SmallHomePermissionManagerFragment smallHomePermissionManagerFragment, ItemType itemType, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        smallHomePermissionManagerFragment.Wh(itemType, z16);
    }

    private final ItemType Dh(int status) {
        if (status == 1) {
            return ItemType.ALL;
        }
        if (status == 2) {
            return ItemType.FRIENDS;
        }
        if (status == 3) {
            return ItemType.SELF;
        }
        if (status != 4) {
            return null;
        }
        return ItemType.SELECT_FRIENDS;
    }
}
