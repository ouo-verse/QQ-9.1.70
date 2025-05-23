package com.qzone.reborn.groupalbum.viewmodel;

import android.app.Activity;
import android.content.DialogInterface;
import com.qzone.feed.utils.QZoneFeedUtil;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellGroupAlbumInfo;
import com.qzone.publish.business.publishqueue.common.CommonPublishQueue;
import com.qzone.publish.business.task.IQueueTask;
import com.qzone.reborn.base.n;
import com.qzone.util.ToastUtil;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\b\u0016\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001fB\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002JC\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00042!\u0010\r\u001a\u001d\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00020\f0\tH\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0016J=\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022!\u0010\r\u001a\u001d\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00020\f0\tH\u0016J9\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022!\u0010\r\u001a\u001d\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00020\f0\tJ\u0006\u0010\u0013\u001a\u00020\u0004R\"\u0010\u001b\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a\u00a8\u0006 "}, d2 = {"Lcom/qzone/reborn/groupalbum/viewmodel/m;", "Lcom/qzone/reborn/base/n;", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "feedData", "", "U1", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "isDelMediaFileInAlbum", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "", "successFunc", "S1", "", "getLogTag", "Q1", "W1", "T1", "Lki/aa;", "i", "Lki/aa;", "getMFeedsDataRepo", "()Lki/aa;", "setMFeedsDataRepo", "(Lki/aa;)V", "mFeedsDataRepo", "<init>", "()V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public class m extends com.qzone.reborn.base.n {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private ki.aa mFeedsDataRepo = new ki.aa();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u001a\u0010\u000e\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\u000f"}, d2 = {"com/qzone/reborn/groupalbum/viewmodel/m$b", "Lcom/qzone/reborn/base/n$a;", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "feedData", "", "retCode", "", "msg", "", "isFinish", "", "a", "errorCode", "errorMsg", "onFailure", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b implements n.a<BusinessFeedData> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<BusinessFeedData, Unit> f57105a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ BusinessFeedData f57106b;

        /* JADX WARN: Multi-variable type inference failed */
        b(Function1<? super BusinessFeedData, Unit> function1, BusinessFeedData businessFeedData) {
            this.f57105a = function1;
            this.f57106b = businessFeedData;
        }

        @Override // com.qzone.reborn.base.n.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(BusinessFeedData feedData, long retCode, String msg2, boolean isFinish) {
            Intrinsics.checkNotNullParameter(feedData, "feedData");
            Intrinsics.checkNotNullParameter(msg2, "msg");
            Function1<BusinessFeedData, Unit> function1 = this.f57105a;
            if (function1 != null) {
                function1.invoke(feedData);
            }
            ToastUtil.g("\u5220\u9664\u6210\u529f", 2);
        }

        @Override // com.qzone.reborn.base.n.a
        public void onFailure(long errorCode, String errorMsg) {
            if (this.f57106b.isFakeFeed()) {
                return;
            }
            ToastUtil.s("\u5220\u9664\u5931\u8d25", 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R1(m this$0, Activity activity, BusinessFeedData businessFeedData, Function1 successFunc, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(activity, "$activity");
        Intrinsics.checkNotNullParameter(successFunc, "$successFunc");
        this$0.S1(activity, businessFeedData, false, successFunc);
    }

    private final void S1(Activity activity, BusinessFeedData feedData, boolean isDelMediaFileInAlbum, Function1<? super BusinessFeedData, Unit> successFunc) {
        if (!NetworkUtil.isNetSupport(activity)) {
            com.qzone.reborn.util.o.f59556a.b(com.qzone.reborn.configx.g.f53821a.m().k());
            return;
        }
        if (feedData.isFakeFeed()) {
            CellGroupAlbumInfo cellGroupAlbumInfo = feedData.cellGroupAlbumInfo;
            String str = cellGroupAlbumInfo != null ? cellGroupAlbumInfo.groupId : null;
            if (str == null) {
                str = "";
            }
            if (str.length() == 0) {
                RFWLog.e("GroupAlbumDeleteFeedViewModel", RFWLog.USR, "[doDeleteFeed] delete fail, group id is empty");
                return;
            }
            CommonPublishQueue c16 = z8.c.f452134a.c(str);
            CopyOnWriteArrayList<IQueueTask> a16 = c16.a();
            ArrayList arrayList = new ArrayList();
            for (Object obj : a16) {
                if (Intrinsics.areEqual(((IQueueTask) obj).getClientKey(), feedData.getFeedCommInfo().clientkey)) {
                    arrayList.add(obj);
                }
            }
            RFWLog.e("GroupAlbumDeleteFeedViewModel", RFWLog.USR, "[doDeleteFeed] needDelPublishTasks size: " + arrayList.size() + ", groupId: " + str);
            if (arrayList.isEmpty()) {
                fj.n nVar = fj.n.f399459a;
                String str2 = feedData.getFeedCommInfo().clientkey;
                Intrinsics.checkNotNullExpressionValue(str2, "feedData.feedCommInfo.clientkey");
                nVar.A(str, str2);
            } else {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    c16.f((IQueueTask) it.next());
                }
            }
        }
        CellGroupAlbumInfo cellGroupAlbumInfo2 = feedData.cellGroupAlbumInfo;
        this.mFeedsDataRepo.e(this.contextHashCode, feedData, cellGroupAlbumInfo2 != null ? cellGroupAlbumInfo2.groupId : null, isDelMediaFileInAlbum, new b(successFunc, feedData));
    }

    private final boolean U1(BusinessFeedData feedData) {
        if (feedData.getFeedCommInfo() == null) {
            return false;
        }
        return ef.b.c(feedData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X1(Ref.BooleanRef isDelMediaFileInAlbum, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(isDelMediaFileInAlbum, "$isDelMediaFileInAlbum");
        isDelMediaFileInAlbum.element = i3 == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z1(m this$0, Activity activity, BusinessFeedData feedData, Ref.BooleanRef isDelMediaFileInAlbum, Function1 successFunc, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(activity, "$activity");
        Intrinsics.checkNotNullParameter(feedData, "$feedData");
        Intrinsics.checkNotNullParameter(isDelMediaFileInAlbum, "$isDelMediaFileInAlbum");
        Intrinsics.checkNotNullParameter(successFunc, "$successFunc");
        this$0.S1(activity, feedData, isDelMediaFileInAlbum.element, successFunc);
        com.qzone.reborn.util.i.b().l("GROUP_ALNUM_LAST_DEL_MEDIA_FILE_CHECKED_STATE", isDelMediaFileInAlbum.element);
    }

    public void Q1(final Activity activity, final BusinessFeedData feedData, final Function1<? super BusinessFeedData, Unit> successFunc) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(successFunc, "successFunc");
        if (feedData != null && feedData.getFeedCommInfo() != null) {
            if (U1(feedData)) {
                W1(activity, feedData, successFunc);
                return;
            } else {
                new com.qzone.component.e().g(activity, null, HardCodeUtil.qqStr(R.string.gey), new DialogInterface.OnClickListener() { // from class: com.qzone.reborn.groupalbum.viewmodel.i
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i3) {
                        m.R1(m.this, activity, feedData, successFunc, dialogInterface, i3);
                    }
                }, null);
                return;
            }
        }
        RFWLog.e("GroupAlbumDeleteFeedViewModel", RFWLog.USR, "feedData or feedCommInfo is null");
    }

    public final boolean T1() {
        return com.qzone.reborn.util.i.b().d("GROUP_ALNUM_LAST_DEL_MEDIA_FILE_CHECKED_STATE", com.qzone.reborn.configx.g.f53821a.g().m());
    }

    public final void W1(final Activity activity, final BusinessFeedData feedData, final Function1<? super BusinessFeedData, Unit> successFunc) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(feedData, "feedData");
        Intrinsics.checkNotNullParameter(successFunc, "successFunc");
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        booleanRef.element = T1();
        QQCustomDialog createDialogWithCheckBox = DialogUtil.createDialogWithCheckBox(activity, 230, null, HardCodeUtil.qqStr(R.string.gey), QZoneFeedUtil.A(feedData), booleanRef.element, HardCodeUtil.qqStr(R.string.gd5), HardCodeUtil.qqStr(R.string.a8j), new DialogInterface.OnClickListener() { // from class: com.qzone.reborn.groupalbum.viewmodel.j
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                m.X1(Ref.BooleanRef.this, dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.qzone.reborn.groupalbum.viewmodel.k
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                m.Z1(m.this, activity, feedData, booleanRef, successFunc, dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.qzone.reborn.groupalbum.viewmodel.l
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                m.a2(dialogInterface, i3);
            }
        });
        Intrinsics.checkNotNullExpressionValue(createDialogWithCheckBox, "createDialogWithCheckBox\u2026, which ->}\n            )");
        createDialogWithCheckBox.show();
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return "GroupAlbumDeleteFeedViewModel";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a2(DialogInterface dialogInterface, int i3) {
    }
}
