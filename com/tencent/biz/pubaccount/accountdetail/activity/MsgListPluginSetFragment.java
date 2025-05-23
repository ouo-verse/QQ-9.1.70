package com.tencent.biz.pubaccount.accountdetail.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.core.content.res.ResourcesCompat;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.entity.MsgListPluginEntity;
import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDataCardApi;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager;
import com.tencent.biz.pubaccount.util.MsgListPluginDataManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.proavatar.QQProAvatarDrawable;
import com.tencent.mobileqq.proavatar.e;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.setting.fragment.BaseSettingFragment;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.chats.biz.publicaccount.IPublicAccountChatsApi;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 )2\u00020\u0001:\u0001*B\u0007\u00a2\u0006\u0004\b'\u0010(J\b\u0010\u0003\u001a\u00020\u0002H\u0002J$\u0010\b\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\u001e\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\u0005H\u0002J\u001a\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0013\u001a\u00020\u0002H\u0016J\b\u0010\u0014\u001a\u00020\u0002H\u0016R;\u0010\u001d\u001a&\u0012\f\u0012\n \u0017*\u0004\u0018\u00010\u00160\u0016 \u0017*\u0012\u0012\f\u0012\n \u0017*\u0004\u0018\u00010\u00160\u0016\u0018\u00010\u00180\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR;\u0010 \u001a&\u0012\f\u0012\n \u0017*\u0004\u0018\u00010\u00160\u0016 \u0017*\u0012\u0012\f\u0012\n \u0017*\u0004\u0018\u00010\u00160\u0016\u0018\u00010\u00180\u00158\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001a\u001a\u0004\b\u001f\u0010\u001cR\u0017\u0010&\u001a\u00020!8\u0006\u00a2\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\u00a8\u0006+"}, d2 = {"Lcom/tencent/biz/pubaccount/accountdetail/activity/MsgListPluginSetFragment;", "Lcom/tencent/mobileqq/setting/fragment/BaseSettingFragment;", "", "initData", "", "Lcom/tencent/biz/entity/MsgListPluginEntity;", "enableList", "disableList", "Hh", "entity", "Lcom/tencent/mobileqq/widget/listitem/x;", "Lcom/tencent/mobileqq/widget/listitem/x$b$b;", "Lcom/tencent/mobileqq/widget/listitem/x$c$g;", "Eh", "Landroid/view/View;", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "onResume", "", "", "kotlin.jvm.PlatformType", "", "J", "Ljava/util/Set;", "getStudyWhiteList", "()Ljava/util/Set;", "studyWhiteList", "K", "getConsciseWhiteList", "consciseWhiteList", "Lux/a;", "L", "Lux/a;", "getListener", "()Lux/a;", "listener", "<init>", "()V", "M", "a", "qqpubaccount_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class MsgListPluginSetFragment extends BaseSettingFragment {

    /* renamed from: J, reason: from kotlin metadata */
    private final Set<String> studyWhiteList = ServiceAccountFolderManager.h();

    /* renamed from: K, reason: from kotlin metadata */
    private final Set<String> consciseWhiteList = ServiceAccountFolderManager.g();

    /* renamed from: L, reason: from kotlin metadata */
    private final ux.a listener = new ux.a() { // from class: com.tencent.biz.pubaccount.accountdetail.activity.MsgListPluginSetFragment$listener$1
        @Override // ux.a
        public void a(ArrayList<MsgListPluginEntity> changeList) {
            Intrinsics.checkNotNullParameter(changeList, "changeList");
            QLog.i("MsgListPluginSetFragment", 1, "onPluginListChange size " + changeList.size());
            MsgListPluginDataManager msgListPluginDataManager = MsgListPluginDataManager.f80156a;
            final MsgListPluginSetFragment msgListPluginSetFragment = MsgListPluginSetFragment.this;
            msgListPluginDataManager.k(new Function2<List<? extends MsgListPluginEntity>, List<? extends MsgListPluginEntity>, Unit>() { // from class: com.tencent.biz.pubaccount.accountdetail.activity.MsgListPluginSetFragment$listener$1$onPluginListChange$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(List<? extends MsgListPluginEntity> list, List<? extends MsgListPluginEntity> list2) {
                    invoke2(list, list2);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(List<? extends MsgListPluginEntity> enableList, List<? extends MsgListPluginEntity> disableList) {
                    Intrinsics.checkNotNullParameter(enableList, "enableList");
                    Intrinsics.checkNotNullParameter(disableList, "disableList");
                    MsgListPluginSetFragment.this.Hh(enableList, disableList);
                }
            });
        }
    };

    private final x<x.b.C8996b, x.c.g> Eh(final MsgListPluginEntity entity) {
        boolean simpleUISwitch = SimpleUIUtil.getSimpleUISwitch();
        boolean studyModeSwitch = ((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch();
        if (simpleUISwitch && !this.consciseWhiteList.contains(String.valueOf(entity.luin))) {
            QLog.i("MsgListPluginSetFragment", 1, "not show plugin " + entity.name + " uin " + entity.luin + " because simple mode");
            return null;
        }
        if (studyModeSwitch && !this.studyWhiteList.contains(String.valueOf(entity.luin))) {
            QLog.i("MsgListPluginSetFragment", 1, "not show plugin " + entity.name + " uin " + entity.luin + " because study mode");
            return null;
        }
        String str = entity.name;
        Intrinsics.checkNotNullExpressionValue(str, "entity.name");
        x<x.b.C8996b, x.c.g> xVar = new x<>(new x.b.C8996b(str, R.drawable.qui_add), new x.c.g("", true, false, 4, null));
        xVar.x(new View.OnClickListener() { // from class: com.tencent.biz.pubaccount.accountdetail.activity.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MsgListPluginSetFragment.Fh(MsgListPluginEntity.this, this, view);
            }
        });
        xVar.S(new Function2<ImageView, Integer, Unit>() { // from class: com.tencent.biz.pubaccount.accountdetail.activity.MsgListPluginSetFragment$getPluginItemConfig$1$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(ImageView imageView, Integer num) {
                invoke(imageView, num.intValue());
                return Unit.INSTANCE;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r25v0, types: [android.widget.ImageView, android.view.View, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r4v0 */
            /* JADX WARN: Type inference failed for: r4v1 */
            /* JADX WARN: Type inference failed for: r4v2, types: [android.graphics.drawable.Drawable] */
            /* JADX WARN: Type inference failed for: r4v3, types: [com.tencent.mobileqq.proavatar.QQProAvatarDrawable] */
            /* JADX WARN: Type inference failed for: r4v4, types: [android.graphics.drawable.Drawable] */
            /* JADX WARN: Type inference failed for: r4v5 */
            public final void invoke(ImageView imageView, int i3) {
                Intrinsics.checkNotNullParameter(imageView, "imageView");
                Integer publicAccountIcon = ((IPublicAccountChatsApi) QRoute.api(IPublicAccountChatsApi.class)).getPublicAccountIcon(Long.valueOf(MsgListPluginEntity.this.luin));
                Context context = this.getContext();
                ?? r46 = 0;
                r46 = 0;
                Resources resources = context != null ? context.getResources() : null;
                if (publicAccountIcon != null && resources != null) {
                    r46 = ResourcesCompat.getDrawable(resources, publicAccountIcon.intValue(), null);
                }
                if (r46 == 0) {
                    r46 = new QQProAvatarDrawable();
                    r46.r(this.getContext(), 1, String.valueOf(MsgListPluginEntity.this.luin), new e.a(0, false, false, false, 0, false, 0, 0, null, false, false, 0, null, null, 0, 32767, null).g(100).a());
                }
                imageView.setImageDrawable(r46);
                imageView.setAlpha(MsgListPluginEntity.this.isEnable ? 1.0f : 0.5f);
            }
        });
        return xVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Fh(MsgListPluginEntity entity, MsgListPluginSetFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(entity, "$entity");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intent intent = new Intent();
        intent.putExtra("uin", String.valueOf(entity.luin));
        Context context = this$0.getContext();
        if (context != null) {
            ((IPublicAccountDataCardApi) QRoute.api(IPublicAccountDataCardApi.class)).startPublicAccountDataCardPage(context, intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Gh() {
        MsgListPluginDataManager.f80156a.h("MsgListPluginSetFragment");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ih(MsgListPluginSetFragment this$0, ArrayList groupList) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(groupList, "$groupList");
        QUIListItemAdapter th5 = this$0.th();
        if (th5 != null) {
            Object[] array = groupList.toArray(new Group[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            Group[] groupArr = (Group[]) array;
            th5.t0((Group[]) Arrays.copyOf(groupArr, groupArr.length));
        }
        QUIListItemAdapter th6 = this$0.th();
        if (th6 != null) {
            th6.notifyDataSetChanged();
        }
    }

    private final void initData() {
        MsgListPluginDataManager.f80156a.k(new Function2<List<? extends MsgListPluginEntity>, List<? extends MsgListPluginEntity>, Unit>() { // from class: com.tencent.biz.pubaccount.accountdetail.activity.MsgListPluginSetFragment$initData$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends MsgListPluginEntity> list, List<? extends MsgListPluginEntity> list2) {
                invoke2(list, list2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<? extends MsgListPluginEntity> enableList, List<? extends MsgListPluginEntity> disableList) {
                Intrinsics.checkNotNullParameter(enableList, "enableList");
                Intrinsics.checkNotNullParameter(disableList, "disableList");
                MsgListPluginSetFragment.this.Hh(enableList, disableList);
            }
        });
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.biz.pubaccount.accountdetail.activity.b
            @Override // java.lang.Runnable
            public final void run() {
                MsgListPluginSetFragment.Gh();
            }
        }, 128, null, true);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        MsgListPluginDataManager.f80156a.p("MsgListPluginSetFragment", this.listener);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        initData();
    }

    @Override // com.tencent.mobileqq.setting.fragment.BaseSettingFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        String qqStr = HardCodeUtil.qqStr(R.string.xaj);
        Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.msg_list_plugin_fragment_title)");
        setTitle(qqStr);
        MsgListPluginDataManager.f80156a.g("MsgListPluginSetFragment", this.listener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Hh(List<? extends MsgListPluginEntity> enableList, List<? extends MsgListPluginEntity> disableList) {
        ArrayList arrayList;
        ArrayList arrayList2 = null;
        if (enableList != null) {
            arrayList = new ArrayList();
            Iterator<T> it = enableList.iterator();
            while (it.hasNext()) {
                x<x.b.C8996b, x.c.g> Eh = Eh((MsgListPluginEntity) it.next());
                if (Eh != null) {
                    arrayList.add(Eh);
                }
            }
        } else {
            arrayList = null;
        }
        if (disableList != null) {
            arrayList2 = new ArrayList();
            Iterator<T> it5 = disableList.iterator();
            while (it5.hasNext()) {
                x<x.b.C8996b, x.c.g> Eh2 = Eh((MsgListPluginEntity) it5.next());
                if (Eh2 != null) {
                    arrayList2.add(Eh2);
                }
            }
        }
        final ArrayList arrayList3 = new ArrayList();
        boolean z16 = true;
        if (!(arrayList == null || arrayList.isEmpty())) {
            Object[] array = arrayList.toArray(new x[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            x[] xVarArr = (x[]) array;
            arrayList3.add(new Group("\u5df2\u542f\u7528\u7684\u529f\u80fd", (com.tencent.mobileqq.widget.listitem.a[]) Arrays.copyOf(xVarArr, xVarArr.length)));
        }
        if (arrayList2 != null && !arrayList2.isEmpty()) {
            z16 = false;
        }
        if (!z16) {
            Object[] array2 = arrayList2.toArray(new x[0]);
            Intrinsics.checkNotNull(array2, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            x[] xVarArr2 = (x[]) array2;
            arrayList3.add(new Group("\u672a\u542f\u7528\u7684\u529f\u80fd", (com.tencent.mobileqq.widget.listitem.a[]) Arrays.copyOf(xVarArr2, xVarArr2.length)));
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.biz.pubaccount.accountdetail.activity.a
            @Override // java.lang.Runnable
            public final void run() {
                MsgListPluginSetFragment.Ih(MsgListPluginSetFragment.this, arrayList3);
            }
        });
    }
}
