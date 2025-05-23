package com.tencent.mobileqq.troop.livesync.view.trooplist;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.CompoundButton;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import com.tencent.mobileqq.widget.listitem.QUISettingsRecyclerView;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.trpcprotocol.TroopLiveSyncSvr$GetSyncGroupsRsp;
import tencent.trpcprotocol.TroopLiveSyncSvr$GroupInfo;
import tencent.trpcprotocol.TroopLiveSyncSvr$SetSyncGroupRsp;

/* compiled from: P */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 L2\u00020\u0001:\u0001MB\u001b\u0012\u0006\u00102\u001a\u00020/\u0012\n\b\u0002\u0010I\u001a\u0004\u0018\u00010H\u00a2\u0006\u0004\bJ\u0010KJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0018\u0010\u000e\u001a\u0004\u0018\u00010\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J\u0018\u0010\u000f\u001a\u0004\u0018\u00010\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J\u000e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000bH\u0002J<\u0010\u001a\u001a6\u0012\u0013\u0012\u00110\u0013\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00110\u0017\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u00020\u0012j\u0002`\u0019H\u0003J\u0018\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u001cH\u0002J\u0010\u0010 \u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u001cH\u0003J\u0010\u0010\"\u001a\u00020\u00022\u0006\u0010!\u001a\u00020\u0007H\u0002J\u000e\u0010%\u001a\u00020\u00022\u0006\u0010$\u001a\u00020#J\u000e\u0010'\u001a\u00020\u00022\u0006\u0010&\u001a\u00020\u001cJ\u000e\u0010)\u001a\u00020\u00022\u0006\u0010(\u001a\u00020\u0007J\"\u0010-\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020+0*J\u0006\u0010.\u001a\u00020\u0002R\u0014\u00102\u001a\u00020/8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0016\u00105\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0016\u00108\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010:\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u00104R\u0016\u0010<\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u00107R\"\u0010?\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020+0*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010B\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0018\u0010E\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u0018\u0010G\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u0010F\u00a8\u0006N"}, d2 = {"Lcom/tencent/mobileqq/troop/livesync/view/trooplist/TroopLiveSyncListView;", "Lcom/tencent/mobileqq/widget/listitem/QUISettingsRecyclerView;", "", "W", "Ltencent/trpcprotocol/TroopLiveSyncSvr$GetSyncGroupsRsp;", "rsp", "V", "", "checkDefault", "Lcom/tencent/mobileqq/widget/listitem/Group;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "", "Ltencent/trpcprotocol/TroopLiveSyncSvr$GroupInfo;", "troops", "P", "O", "", ExifInterface.LATITUDE_SOUTH, "Lkotlin/Function2;", "Landroid/widget/CompoundButton;", "Lkotlin/ParameterName;", "name", "checkBox", "Lcom/tencent/mobileqq/troop/livesync/view/trooplist/c;", DownloadInfo.spKey_Config, "Lcom/tencent/mobileqq/troop/livesync/view/trooplist/TroopLiveSyncCheckedChangeCallback;", "T", "bCheck", "", "syncSize", "L", "count", "X", "isChecked", "K", "Lcom/tencent/mobileqq/troop/livesync/view/trooplist/a;", "listener", "setSyncListStateChangeListener", "roomId", "setRoomId", "fromLiveStart", "setIsFromLiveStart", "", "Lcom/tencent/mobileqq/data/troop/TroopInfo;", "troopsInfo", "U", "M", "Landroid/content/Context;", "i", "Landroid/content/Context;", "mContext", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Z", "bSync", BdhLogUtil.LogTag.Tag_Conn, "I", "mRoomId", "D", "isFromLiveStart", "E", "mAbleSyncMaxCount", UserInfo.SEX_FEMALE, "Ljava/util/Map;", "mTroopsInfo", "G", "Ltencent/trpcprotocol/TroopLiveSyncSvr$GetSyncGroupsRsp;", "mRspModel", "H", "Lcom/tencent/mobileqq/troop/livesync/view/trooplist/a;", "mListener", "Lcom/tencent/mobileqq/widget/listitem/Group;", "ableGroupConfig", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "J", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopLiveSyncListView extends QUISettingsRecyclerView {
    static IPatchRedirector $redirector_;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private int mRoomId;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean isFromLiveStart;

    /* renamed from: E, reason: from kotlin metadata */
    private int mAbleSyncMaxCount;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private Map<Long, ? extends TroopInfo> mTroopsInfo;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private TroopLiveSyncSvr$GetSyncGroupsRsp mRspModel;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private a mListener;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private Group ableGroupConfig;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context mContext;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean bSync;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/livesync/view/trooplist/TroopLiveSyncListView$a;", "", "", "Log_TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.livesync.view.trooplist.TroopLiveSyncListView$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(54469);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TroopLiveSyncListView(@NotNull Context mContext, @Nullable AttributeSet attributeSet) {
        super(mContext, attributeSet);
        Map<Long, ? extends TroopInfo> emptyMap;
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) mContext, (Object) attributeSet);
            return;
        }
        this.mContext = mContext;
        emptyMap = MapsKt__MapsKt.emptyMap();
        this.mTroopsInfo = emptyMap;
        this.mRspModel = new TroopLiveSyncSvr$GetSyncGroupsRsp();
        setDividerStyle(QUISettingsRecyclerView.DividerStyle.Hidden);
        setAdapter(new QUIListItemAdapter(null, false, false, 7, null));
    }

    private final void K(boolean isChecked) {
        if (isChecked) {
            V(this.mRspModel);
        } else {
            W();
        }
        this.bSync = isChecked;
        a aVar = this.mListener;
        if (aVar != null) {
            aVar.b(isChecked);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean L(boolean bCheck, int syncSize) {
        boolean z16;
        if (bCheck && syncSize > this.mAbleSyncMaxCount) {
            String string = this.mContext.getString(R.string.f234737_r);
            Intrinsics.checkNotNullExpressionValue(string, "mContext.getString(R.str\u2026_live_sync_group_max_tip)");
            Context context = this.mContext;
            String format = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(this.mAbleSyncMaxCount)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
            QQToast.makeText(context, 0, format, 0).show();
        } else {
            PBBoolField pBBoolField = this.mRspModel.unable_edit;
            if (pBBoolField != null && pBBoolField.get()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                return true;
            }
            String string2 = this.mContext.getString(R.string.f234757_t);
            Intrinsics.checkNotNullExpressionValue(string2, "mContext.getString(R.str\u2026p_live_sync_multiple_tip)");
            QQToast.makeText(this.mContext, 0, string2, 0).show();
        }
        return false;
    }

    private final Group O(List<TroopLiveSyncSvr$GroupInfo> troops) {
        long j3;
        if (troops.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = troops.iterator();
        while (true) {
            boolean z16 = false;
            if (!it.hasNext()) {
                break;
            }
            TroopLiveSyncSvr$GroupInfo troopLiveSyncSvr$GroupInfo = (TroopLiveSyncSvr$GroupInfo) it.next();
            PBUInt64Field pBUInt64Field = troopLiveSyncSvr$GroupInfo.group_code;
            if (pBUInt64Field != null) {
                j3 = pBUInt64Field.get();
            } else {
                j3 = 0;
            }
            TroopInfo troopInfo = this.mTroopsInfo.get(Long.valueOf(j3));
            if (j3 > 0 && troopInfo != null) {
                PBBoolField pBBoolField = troopLiveSyncSvr$GroupInfo.be_choosed;
                if (pBBoolField != null) {
                    z16 = pBBoolField.get();
                }
                arrayList.add(new c(troopLiveSyncSvr$GroupInfo, troopInfo, z16, false, null, 16, null));
            }
        }
        if (!(!arrayList.isEmpty())) {
            return null;
        }
        String string = this.mContext.getString(R.string.f234787_w);
        Intrinsics.checkNotNullExpressionValue(string, "mContext.getString(R.str\u2026p_live_sync_warning_text)");
        Object[] array = arrayList.toArray(new com.tencent.mobileqq.widget.listitem.a[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        com.tencent.mobileqq.widget.listitem.a[] aVarArr = (com.tencent.mobileqq.widget.listitem.a[]) array;
        return new Group(string, (com.tencent.mobileqq.widget.listitem.a[]) Arrays.copyOf(aVarArr, aVarArr.length));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Group P(List<TroopLiveSyncSvr$GroupInfo> troops) {
        int i3;
        if (troops.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i16 = 0;
        for (TroopLiveSyncSvr$GroupInfo troopLiveSyncSvr$GroupInfo : troops) {
            long j3 = troopLiveSyncSvr$GroupInfo.group_code.get();
            TroopInfo troopInfo = this.mTroopsInfo.get(Long.valueOf(j3));
            if (j3 > 0 && troopInfo != null) {
                PBBoolField pBBoolField = troopLiveSyncSvr$GroupInfo.be_choosed;
                if (pBBoolField != null) {
                    i3 = pBBoolField.get() ? 1 : 0;
                } else {
                    i3 = 0;
                }
                if (i16 < this.mAbleSyncMaxCount) {
                    i16 += i3;
                    arrayList.add(new c(troopLiveSyncSvr$GroupInfo, troopInfo, i3, true, T()));
                } else {
                    arrayList.add(new c(troopLiveSyncSvr$GroupInfo, troopInfo, false, true, T()));
                    if (i3 != 0) {
                        QLog.e("TroopLiveSync", 1, "choose count exceed max count, [roomId:" + this.mRoomId + "]");
                    }
                }
            }
        }
        if (!(!arrayList.isEmpty())) {
            return null;
        }
        String string = this.mContext.getString(R.string.f234697_n);
        Intrinsics.checkNotNullExpressionValue(string, "mContext.getString(R.str\u2026ive_sync_choose_num_text)");
        String format = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(i16), Integer.valueOf(this.mAbleSyncMaxCount)}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        Object[] array = arrayList.toArray(new com.tencent.mobileqq.widget.listitem.a[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        com.tencent.mobileqq.widget.listitem.a[] aVarArr = (com.tencent.mobileqq.widget.listitem.a[]) array;
        return new Group(format, (com.tencent.mobileqq.widget.listitem.a[]) Arrays.copyOf(aVarArr, aVarArr.length));
    }

    private final Group Q(boolean checkDefault) {
        String string = this.mContext.getString(R.string.f234767_u);
        Intrinsics.checkNotNullExpressionValue(string, "mContext.getString(R.str\u2026op_live_sync_switch_text)");
        return new Group(new x(new x.b.d(string), new x.c.f(checkDefault, new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.troop.livesync.view.trooplist.d
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                TroopLiveSyncListView.R(TroopLiveSyncListView.this, compoundButton, z16);
            }
        })));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R(TroopLiveSyncListView this$0, CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.K(z16);
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:21:0x004d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0013 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List<Long> S() {
        ArrayList<com.tencent.mobileqq.widget.listitem.a<?>> a16;
        long j3;
        Long longOrNull;
        ArrayList arrayList = new ArrayList();
        Group group = this.ableGroupConfig;
        if (group != null && (a16 = group.a()) != null) {
            Iterator<T> it = a16.iterator();
            while (it.hasNext()) {
                com.tencent.mobileqq.widget.listitem.a aVar = (com.tencent.mobileqq.widget.listitem.a) it.next();
                if (aVar instanceof c) {
                    c cVar = (c) aVar;
                    if (cVar.J()) {
                        String troopUin = cVar.N().getTroopUin();
                        if (troopUin != null) {
                            Intrinsics.checkNotNullExpressionValue(troopUin, "troopUin");
                            longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(troopUin);
                            if (longOrNull != null) {
                                j3 = longOrNull.longValue();
                                if (j3 <= 0) {
                                    arrayList.add(Long.valueOf(j3));
                                }
                            }
                        }
                        j3 = 0;
                        if (j3 <= 0) {
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    @SuppressLint({"NotifyDataSetChanged"})
    private final Function2<CompoundButton, c, Unit> T() {
        return new Function2<CompoundButton, c, Unit>() { // from class: com.tencent.mobileqq.troop.livesync.view.trooplist.TroopLiveSyncListView$itemCheckedChange$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopLiveSyncListView.this);
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(CompoundButton compoundButton, c cVar) {
                invoke2(compoundButton, cVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull CompoundButton checkBox, @NotNull c config) {
                List S;
                boolean L;
                a aVar;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) checkBox, (Object) config);
                    return;
                }
                Intrinsics.checkNotNullParameter(checkBox, "checkBox");
                Intrinsics.checkNotNullParameter(config, "config");
                S = TroopLiveSyncListView.this.S();
                L = TroopLiveSyncListView.this.L(config.J(), S.size());
                if (L) {
                    aVar = TroopLiveSyncListView.this.mListener;
                    if (aVar != null) {
                        PBUInt64Field pBUInt64Field = config.M().group_code;
                        aVar.a(pBUInt64Field != null ? pBUInt64Field.get() : 0L, config.J());
                    }
                    TroopLiveSyncListView.this.X(S.size());
                    return;
                }
                config.Q(!checkBox.isChecked());
                checkBox.setChecked(!checkBox.isChecked());
            }
        };
    }

    private final void V(TroopLiveSyncSvr$GetSyncGroupsRsp rsp) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(Q(true));
        List<TroopLiveSyncSvr$GroupInfo> list = rsp.able_sync_groups.get();
        Intrinsics.checkNotNullExpressionValue(list, "rsp.able_sync_groups.get()");
        Group P = P(list);
        this.ableGroupConfig = P;
        if (P != null) {
            Intrinsics.checkNotNull(P);
            arrayList.add(P);
        }
        List<TroopLiveSyncSvr$GroupInfo> list2 = rsp.unable_sync_groups.get();
        Intrinsics.checkNotNullExpressionValue(list2, "rsp.unable_sync_groups.get()");
        Group O = O(list2);
        if (O != null) {
            arrayList.add(O);
        }
        QUIListItemAdapter adapter = getAdapter();
        if (adapter != null) {
            Object[] array = arrayList.toArray(new Group[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            Group[] groupArr = (Group[]) array;
            adapter.t0((Group[]) Arrays.copyOf(groupArr, groupArr.length));
        }
        QLog.i("TroopLiveSync", 1, "switch choose sync, [roomId:" + this.mRoomId + "]");
    }

    private final void W() {
        Group[] groupArr = {Q(false)};
        QUIListItemAdapter adapter = getAdapter();
        if (adapter != null) {
            adapter.t0((Group[]) Arrays.copyOf(groupArr, 1));
        }
        QLog.i("TroopLiveSync", 1, "switch close sync, [roomId:" + this.mRoomId + "]");
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"NotifyDataSetChanged"})
    public final void X(int count) {
        ArrayList<com.tencent.mobileqq.widget.listitem.a<?>> arrayList;
        boolean z16;
        ArrayList<com.tencent.mobileqq.widget.listitem.a<?>> a16;
        Object first;
        Group group = this.ableGroupConfig;
        com.tencent.mobileqq.widget.listitem.a<?> aVar = null;
        if (group != null) {
            arrayList = group.a();
        } else {
            arrayList = null;
        }
        if (arrayList != null && !arrayList.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return;
        }
        String string = this.mContext.getString(R.string.f234697_n);
        Intrinsics.checkNotNullExpressionValue(string, "mContext.getString(R.str\u2026ive_sync_choose_num_text)");
        Group group2 = this.ableGroupConfig;
        if (group2 != null && (a16 = group2.a()) != null) {
            first = CollectionsKt___CollectionsKt.first((List<? extends Object>) a16);
            aVar = (com.tencent.mobileqq.widget.listitem.a) first;
        }
        if (aVar instanceof Group.b) {
            String format = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(count), Integer.valueOf(this.mAbleSyncMaxCount)}, 2));
            Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
            ((Group.b) aVar).F(format);
            QUIListItemAdapter adapter = getAdapter();
            if (adapter != null) {
                adapter.l0(aVar);
            }
        }
    }

    public final void M() {
        final String string;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        List<Long> S = S();
        final String string2 = this.mContext.getString(R.string.f235097aq);
        Intrinsics.checkNotNullExpressionValue(string2, "mContext.getString(R.string.troop_network_failure)");
        if (this.bSync) {
            String string3 = this.mContext.getString(R.string.f234747_s);
            Intrinsics.checkNotNullExpressionValue(string3, "mContext.getString(R.str\u2026_live_sync_group_num_tip)");
            string = String.format(string3, Arrays.copyOf(new Object[]{Integer.valueOf(S.size())}, 1));
            Intrinsics.checkNotNullExpressionValue(string, "format(this, *args)");
        } else {
            string = this.mContext.getString(R.string.f234717_p);
            Intrinsics.checkNotNullExpressionValue(string, "{\n            mContext.g\u2026roup_close_tip)\n        }");
        }
        com.tencent.mobileqq.troop.livesync.repository.c.f297726a.f(this.mRoomId, this.bSync, S, new Function1<TroopLiveSyncSvr$SetSyncGroupRsp, Unit>(string) { // from class: com.tencent.mobileqq.troop.livesync.view.trooplist.TroopLiveSyncListView$confirmSyncData$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ String $tip;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$tip = string;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopLiveSyncListView.this, (Object) string);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(TroopLiveSyncSvr$SetSyncGroupRsp troopLiveSyncSvr$SetSyncGroupRsp) {
                invoke2(troopLiveSyncSvr$SetSyncGroupRsp);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull TroopLiveSyncSvr$SetSyncGroupRsp it) {
                Context context;
                Context context2;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                Intrinsics.checkNotNullParameter(it, "it");
                context = TroopLiveSyncListView.this.mContext;
                if (context != null) {
                    context2 = TroopLiveSyncListView.this.mContext;
                    QQToast.makeText(context2, 2, this.$tip, 0).show();
                }
            }
        }, new Function2<Integer, String, Unit>(string2) { // from class: com.tencent.mobileqq.troop.livesync.view.trooplist.TroopLiveSyncListView$confirmSyncData$2
            static IPatchRedirector $redirector_;
            final /* synthetic */ String $failureTip;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
                this.$failureTip = string2;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopLiveSyncListView.this, (Object) string2);
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str) {
                invoke(num.intValue(), str);
                return Unit.INSTANCE;
            }

            public final void invoke(int i3, @NotNull String str) {
                Context context;
                Context context2;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, i3, (Object) str);
                    return;
                }
                Intrinsics.checkNotNullParameter(str, "<anonymous parameter 1>");
                context = TroopLiveSyncListView.this.mContext;
                if (context != null) {
                    context2 = TroopLiveSyncListView.this.mContext;
                    QQToast.makeText(context2, 1, this.$failureTip, 0).show();
                }
            }
        });
    }

    public final void U(@NotNull TroopLiveSyncSvr$GetSyncGroupsRsp rsp, @NotNull Map<Long, ? extends TroopInfo> troopsInfo) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) rsp, (Object) troopsInfo);
            return;
        }
        Intrinsics.checkNotNullParameter(rsp, "rsp");
        Intrinsics.checkNotNullParameter(troopsInfo, "troopsInfo");
        this.mRspModel = rsp;
        this.mTroopsInfo = troopsInfo;
        PBBoolField pBBoolField = rsp.sync_switch;
        int i3 = 0;
        if (pBBoolField != null) {
            z16 = pBBoolField.get();
        } else {
            z16 = false;
        }
        this.bSync = z16;
        PBInt32Field pBInt32Field = rsp.able_sync_groups_num;
        if (pBInt32Field != null) {
            i3 = pBInt32Field.get();
        }
        this.mAbleSyncMaxCount = i3;
        if (this.bSync) {
            V(rsp);
        } else {
            W();
        }
    }

    public final void setIsFromLiveStart(boolean fromLiveStart) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, fromLiveStart);
        } else {
            this.isFromLiveStart = fromLiveStart;
        }
    }

    public final void setRoomId(int roomId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, roomId);
        } else {
            this.mRoomId = roomId;
        }
    }

    public final void setSyncListStateChangeListener(@NotNull a listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) listener);
        } else {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.mListener = listener;
        }
    }
}
