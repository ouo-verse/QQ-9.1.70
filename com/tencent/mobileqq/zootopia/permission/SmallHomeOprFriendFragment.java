package com.tencent.mobileqq.zootopia.permission;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.contacts.alphabet.IndexBar;
import com.tencent.mobileqq.activity.contacts.alphabet.IndexBarTipsLayout;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.selectmember.ISelectMemberActivityConstants;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.zootopia.permission.SmallHomePermissionManagerFragment;
import com.tencent.mobileqq.zootopia.permission.c;
import com.tencent.mobileqq.zootopia.view.z;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QzoneIPCModule;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.CharRange;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00b0\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 X2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001YB\u0007\u00a2\u0006\u0004\bV\u0010WJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0012\u0010\n\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\u0006H\u0002J\b\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000bH\u0002J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0014J&\u0010\u001a\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0014J\u001a\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J\"\u0010\"\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020\u00122\b\u0010!\u001a\u0004\u0018\u00010 H\u0016J\"\u0010(\u001a\u00020\u00042\b\u0010$\u001a\u0004\u0018\u00010#2\u0006\u0010%\u001a\u00020\u00122\u0006\u0010'\u001a\u00020&H\u0016J\u0010\u0010*\u001a\u00020\u00042\u0006\u0010)\u001a\u00020\u0006H\u0016J\u0018\u0010+\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\b\u0010,\u001a\u00020\u0004H\u0016R\u0018\u00100\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00103\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0018\u00106\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0018\u00108\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00105R\u0018\u0010<\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010@\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0018\u0010C\u001a\u0004\u0018\u00010A8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u0010BR\u0018\u0010G\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010FR&\u0010M\u001a\u0012\u0012\u0004\u0012\u00020I0Hj\b\u0012\u0004\u0012\u00020I`J8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u0010LR\u0018\u0010Q\u001a\u0004\u0018\u00010N8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bO\u0010PR\u0018\u0010U\u001a\u0004\u0018\u00010R8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bS\u0010T\u00a8\u0006Z"}, d2 = {"Lcom/tencent/mobileqq/zootopia/permission/SmallHomeOprFriendFragment;", "Lcom/tencent/mobileqq/fragment/QIphoneTitleBarFragment;", "Lcom/tencent/mobileqq/activity/contacts/alphabet/IndexBar$a;", "Lcom/tencent/mobileqq/zootopia/permission/c$d;", "", OcrConfig.CHINESE, "", NodeProps.VISIBLE, "Ch", "needSetData", "Gh", "Lcom/tencent/mobileqq/zootopia/permission/SmallHomePermissionManagerFragment$ItemType;", "yh", "type", "Bh", "", "uin", "Dh", "", "getContentLayoutId", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "doOnCreateView", "Landroid/view/View;", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "", "letter", "action", "", com.tencent.luggage.wxa.c8.c.G, "p1", "touching", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "D8", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Landroid/widget/TextView;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/TextView;", QQWinkConstants.TAB_SUBTITLE, "D", "I", "itemType", "E", "Landroid/view/View;", "emptyLayout", UserInfo.SEX_FEMALE, "listLayout", "Landroidx/recyclerview/widget/RecyclerView;", "G", "Landroidx/recyclerview/widget/RecyclerView;", "listView", "Lcom/tencent/mobileqq/activity/contacts/alphabet/IndexBar;", "H", "Lcom/tencent/mobileqq/activity/contacts/alphabet/IndexBar;", "indexBar", "Lcom/tencent/mobileqq/activity/contacts/alphabet/IndexBarTipsLayout;", "Lcom/tencent/mobileqq/activity/contacts/alphabet/IndexBarTipsLayout;", "indexBarTipsLayout", "Luc3/a;", "J", "Luc3/a;", "scene", "Ljava/util/ArrayList;", "Lhw4/j;", "Lkotlin/collections/ArrayList;", "K", "Ljava/util/ArrayList;", "list", "Lcom/tencent/mobileqq/zootopia/view/z;", "L", "Lcom/tencent/mobileqq/zootopia/view/z;", "loadingDialog", "Lcom/tencent/mobileqq/zootopia/permission/c;", "M", "Lcom/tencent/mobileqq/zootopia/permission/c;", "adapter", "<init>", "()V", "N", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class SmallHomeOprFriendFragment extends QIphoneTitleBarFragment implements IndexBar.a, c.d {

    /* renamed from: C, reason: from kotlin metadata */
    private TextView subTitle;

    /* renamed from: D, reason: from kotlin metadata */
    private int itemType;

    /* renamed from: E, reason: from kotlin metadata */
    private View emptyLayout;

    /* renamed from: F, reason: from kotlin metadata */
    private View listLayout;

    /* renamed from: G, reason: from kotlin metadata */
    private RecyclerView listView;

    /* renamed from: H, reason: from kotlin metadata */
    private IndexBar indexBar;

    /* renamed from: I, reason: from kotlin metadata */
    private IndexBarTipsLayout indexBarTipsLayout;

    /* renamed from: J, reason: from kotlin metadata */
    private uc3.a scene;

    /* renamed from: K, reason: from kotlin metadata */
    private ArrayList<hw4.j> list = new ArrayList<>();

    /* renamed from: L, reason: from kotlin metadata */
    private z loadingDialog;

    /* renamed from: M, reason: from kotlin metadata */
    private c adapter;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ah(SmallHomeOprFriendFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Bh(this$0.yh());
        uc3.a aVar = this$0.scene;
        if (aVar != null) {
            aVar.c();
        }
    }

    private final void Bh(SmallHomePermissionManagerFragment.ItemType type) {
        String str;
        int collectionSizeOrDefault;
        uc3.a aVar = this.scene;
        if (aVar == null || (str = aVar.f()) == null) {
            str = "\u6307\u5b9a\u597d\u53cb";
        }
        int max = Math.max(com.tencent.mobileqq.zootopia.g.f328305a.b() - this.list.size(), 0);
        if (max == 0) {
            QQToast.makeText(getContext(), 1, "\u6dfb\u52a0\u540d\u5355\u8fbe\u5230\u4e0a\u9650", 0).show();
            return;
        }
        Intent intent = new Intent();
        intent.putExtra(ISelectMemberActivityConstants.PARAM_ONLY_FRIENDS, true);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_TITLE, str);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_DONE_BUTTON_WORDING, "\u786e\u8ba4");
        intent.putExtra(ISelectMemberActivityConstants.PARAM_SHOW_DONE_BUTTON_IN_BOTTOM, true);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_ENTRANCE, 44);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_MAX, max);
        intent.putExtra("param_item_type", type);
        ArrayList<hw4.j> arrayList = this.list;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(String.valueOf(((hw4.j) it.next()).f406525a));
        }
        Intent putStringArrayListExtra = intent.putStringArrayListExtra(ISelectMemberActivityConstants.PARAM_UIN_SELECT_DEFAULT, new ArrayList<>(arrayList2));
        Intrinsics.checkNotNullExpressionValue(putStringArrayListExtra, "Intent().apply {\n       \u2026p { it.uin.toString() }))");
        RouteUtils.startActivityForResult(requireActivity(), putStringArrayListExtra, RouterConstants.UI_ROUTE_SELECTMEMBER, 381);
    }

    private final void Dh(final long uin) {
        Context context = getContext();
        uc3.a aVar = this.scene;
        DialogUtil.createCustomDialog(context, 0, "\u662f\u5426\u8981\u79fb\u9664", aVar != null ? aVar.e() : null, "\u53d6\u6d88", "\u786e\u5b9a\u79fb\u9664", new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.zootopia.permission.f
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                SmallHomeOprFriendFragment.Eh(SmallHomeOprFriendFragment.this, uin, dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.zootopia.permission.g
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                SmallHomeOprFriendFragment.Fh(dialogInterface, i3);
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Eh(SmallHomeOprFriendFragment this$0, long j3, DialogInterface dialogInterface, int i3) {
        Object obj;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity != null && this$0.loadingDialog == null) {
            this$0.loadingDialog = new z(activity, false, false, 6, null);
        }
        Iterator<T> it = this$0.list.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            } else {
                obj = it.next();
                if (((hw4.j) obj).f406525a == j3) {
                    break;
                }
            }
        }
        hw4.j jVar = (hw4.j) obj;
        if (jVar == null) {
            return;
        }
        z zVar = this$0.loadingDialog;
        if (zVar != null) {
            zVar.show();
        }
        uc3.a aVar = this$0.scene;
        if (aVar != null) {
            ArrayList<hw4.j> arrayList = new ArrayList<>();
            arrayList.add(jVar);
            aVar.b(arrayList, new SmallHomeOprFriendFragment$showDialog$1$3(this$0, jVar, j3));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Gh(boolean needSetData) {
        if (this.list.isEmpty()) {
            View view = this.emptyLayout;
            if (view != null) {
                view.setVisibility(0);
            }
            View view2 = this.listLayout;
            if (view2 != null) {
                view2.setVisibility(8);
            }
        } else {
            View view3 = this.emptyLayout;
            if (view3 != null) {
                view3.setVisibility(8);
            }
            View view4 = this.listLayout;
            if (view4 != null) {
                view4.setVisibility(0);
            }
            if (needSetData) {
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.zootopia.permission.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        SmallHomeOprFriendFragment.Ih(SmallHomeOprFriendFragment.this);
                    }
                });
            }
        }
        TextView textView = this.subTitle;
        if (textView != null) {
            uc3.a aVar = this.scene;
            textView.setText(aVar != null ? aVar.g(this.list.size()) : null);
        }
        Ch(!this.list.isEmpty());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ih(SmallHomeOprFriendFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        c cVar = this$0.adapter;
        if (cVar != null) {
            cVar.setData(this$0.list);
        }
    }

    private final SmallHomePermissionManagerFragment.ItemType yh() {
        SmallHomePermissionManagerFragment.ItemType[] values = SmallHomePermissionManagerFragment.ItemType.values();
        int i3 = this.itemType;
        if (i3 >= values.length) {
            return SmallHomePermissionManagerFragment.ItemType.UNKNOW;
        }
        return values[i3];
    }

    private final void zh() {
        List mutableList;
        int collectionSizeOrDefault;
        RecyclerView recyclerView = this.listView;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        }
        Context context = getContext();
        if (context != null) {
            c cVar = new c(context);
            cVar.s0(this);
            this.adapter = cVar;
            RecyclerView recyclerView2 = this.listView;
            if (recyclerView2 != null) {
                recyclerView2.setAdapter(cVar);
            }
        }
        IndexBar indexBar = this.indexBar;
        if (indexBar != null) {
            mutableList = CollectionsKt___CollectionsKt.toMutableList(new CharRange(EmotcationConstants.SYS_EMOTCATION_MODULO_OFFSET, 'Z'));
            mutableList.add('#');
            List list = mutableList;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(String.valueOf(((Character) it.next()).charValue()));
            }
            Object[] array = arrayList.toArray(new String[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            indexBar.setLetters((String[]) array);
        }
        IndexBar indexBar2 = this.indexBar;
        if (indexBar2 != null) {
            indexBar2.setOnIndexBarTouchListener(this);
        }
        Ch(false);
    }

    @Override // com.tencent.mobileqq.zootopia.permission.c.d
    public void D8(long uin, View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        Dh(uin);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public void doOnCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        uc3.a bVar;
        Intent intent;
        super.doOnCreateView(inflater, container, savedInstanceState);
        FragmentActivity activity = getActivity();
        int i3 = 0;
        if (activity != null && (intent = activity.getIntent()) != null) {
            i3 = intent.getIntExtra("param_item_type", 0);
        }
        this.itemType = i3;
        if (i3 == SmallHomePermissionManagerFragment.ItemType.SELECT_FRIENDS.ordinal()) {
            bVar = new uc3.c();
        } else {
            bVar = i3 == SmallHomePermissionManagerFragment.ItemType.BLACK_LIST.ordinal() ? new uc3.b() : null;
        }
        this.scene = bVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.d9f;
    }

    @Override // com.tencent.mobileqq.activity.contacts.alphabet.IndexBar.a
    public void m(boolean touching) {
        IndexBar indexBar;
        IndexBarTipsLayout indexBarTipsLayout = this.indexBarTipsLayout;
        if (indexBarTipsLayout != null) {
            indexBarTipsLayout.setVisibility(touching ? 0 : 4);
        }
        if (touching || (indexBar = this.indexBar) == null) {
            return;
        }
        indexBar.setChooseIndex(-1);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0020, code lost:
    
        r8 = kotlin.collections.CollectionsKt___CollectionsKt.filterNotNull(r8);
     */
    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        ArrayList<hw4.j> arrayList;
        z zVar;
        List filterNotNull;
        int collectionSizeOrDefault;
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 381 && data != null && resultCode == -1) {
            Bundle extras = data.getExtras();
            if (extras == null || (r8 = extras.getParcelableArrayList(ISelectMemberActivityConstants.PARAM_RESULT_SET)) == null || filterNotNull == null) {
                arrayList = null;
            } else {
                ArrayList<ResultRecord> arrayList2 = new ArrayList();
                for (Object obj : filterNotNull) {
                    if (((ResultRecord) obj).uin != null) {
                        arrayList2.add(obj);
                    }
                }
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList2, 10);
                arrayList = new ArrayList<>(collectionSizeOrDefault);
                for (ResultRecord resultRecord : arrayList2) {
                    hw4.j jVar = new hw4.j();
                    String str = resultRecord.uin;
                    Intrinsics.checkNotNullExpressionValue(str, "it.uin");
                    jVar.f406525a = Long.parseLong(str);
                    jVar.f406526b = resultRecord.name;
                    jVar.f406527c = null;
                    arrayList.add(jVar);
                }
            }
            ArrayList<hw4.j> arrayList3 = arrayList instanceof ArrayList ? arrayList : null;
            if (arrayList3 == null) {
                return;
            }
            Context context = getContext();
            if (context != null) {
                if (this.loadingDialog == null) {
                    this.loadingDialog = new z(context, false, false, 6, null);
                }
                z zVar2 = this.loadingDialog;
                if (((zVar2 == null || zVar2.isShowing()) ? false : true) && (zVar = this.loadingDialog) != null) {
                    zVar.show();
                }
            }
            uc3.a aVar = this.scene;
            if (aVar != null) {
                aVar.a(arrayList3, new SmallHomeOprFriendFragment$onActivityResult$2(this, arrayList3));
            }
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        z zVar;
        c cVar = this.adapter;
        if (cVar != null) {
            cVar.destroy();
        }
        z zVar2 = this.loadingDialog;
        boolean z16 = false;
        if (zVar2 != null && zVar2.isShowing()) {
            z16 = true;
        }
        if (z16 && (zVar = this.loadingDialog) != null) {
            zVar.dismiss();
        }
        this.loadingDialog = null;
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        TextView textView = (TextView) view.findViewById(R.id.pjq);
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zootopia.permission.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    SmallHomeOprFriendFragment.Ah(SmallHomeOprFriendFragment.this, view2);
                }
            });
        }
        this.emptyLayout = view.findViewById(R.id.prq);
        this.listLayout = view.findViewById(R.id.pju);
        this.listView = (RecyclerView) view.findViewById(R.id.pjp);
        this.indexBar = (IndexBar) view.findViewById(R.id.pjs);
        this.indexBarTipsLayout = (IndexBarTipsLayout) view.findViewById(R.id.pjt);
        this.subTitle = (TextView) view.findViewById(R.id.pjr);
        zh();
        uc3.a aVar = this.scene;
        if (aVar != null) {
            setTitle(aVar.getTitle());
            TextView textView2 = this.subTitle;
            if (textView2 != null) {
                textView2.setText(aVar.g(this.list.size()));
            }
            aVar.d(new Function4<ArrayList<hw4.j>, Integer, Integer, String, Unit>() { // from class: com.tencent.mobileqq.zootopia.permission.SmallHomeOprFriendFragment$onViewCreated$2$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(4);
                }

                @Override // kotlin.jvm.functions.Function4
                public /* bridge */ /* synthetic */ Unit invoke(ArrayList<hw4.j> arrayList, Integer num, Integer num2, String str) {
                    invoke(arrayList, num.intValue(), num2.intValue(), str);
                    return Unit.INSTANCE;
                }

                public final void invoke(ArrayList<hw4.j> arrayList, int i3, int i16, String str) {
                    if (i3 == 1 && arrayList != null) {
                        SmallHomeOprFriendFragment.this.list = arrayList;
                        SmallHomeOprFriendFragment.Hh(SmallHomeOprFriendFragment.this, false, 1, null);
                        return;
                    }
                    QLog.e("SmallHomeOprFriendFragment", 1, "getList errCode:" + i16 + ", errMsg:" + str);
                    QQToast.makeText(SmallHomeOprFriendFragment.this.getContext(), 1, "\u7f51\u7edc\u5f02\u5e38\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5", 0).show();
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.activity.contacts.alphabet.IndexBar.a
    public void p1(String letter, int action, float pos) {
        int l06;
        RecyclerView recyclerView;
        IndexBarTipsLayout indexBarTipsLayout = this.indexBarTipsLayout;
        if (indexBarTipsLayout != null) {
            indexBarTipsLayout.setText(letter, pos);
        }
        c cVar = this.adapter;
        if (cVar == null || (l06 = cVar.l0(letter)) < 0 || (recyclerView = this.listView) == null) {
            return;
        }
        recyclerView.scrollToPosition(l06);
    }

    private final void Ch(boolean visible) {
        if (visible) {
            IndexBar indexBar = this.indexBar;
            if (indexBar != null) {
                indexBar.setVisibility(0);
            }
            IndexBarTipsLayout indexBarTipsLayout = this.indexBarTipsLayout;
            if (indexBarTipsLayout == null) {
                return;
            }
            indexBarTipsLayout.setVisibility(0);
            return;
        }
        IndexBar indexBar2 = this.indexBar;
        if (indexBar2 != null) {
            indexBar2.setVisibility(8);
        }
        IndexBarTipsLayout indexBarTipsLayout2 = this.indexBarTipsLayout;
        if (indexBarTipsLayout2 == null) {
            return;
        }
        indexBarTipsLayout2.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void Hh(SmallHomeOprFriendFragment smallHomeOprFriendFragment, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = true;
        }
        smallHomeOprFriendFragment.Gh(z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Fh(DialogInterface dialogInterface, int i3) {
    }
}
