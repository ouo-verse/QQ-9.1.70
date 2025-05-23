package com.tencent.mobileqq.matchfriend.reborn.content.signal.square.delegate;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.matchfriend.reborn.content.signal.square.section.ClickSection;
import com.tencent.mobileqq.matchfriend.reborn.content.signal.square.section.UserInfoSection;
import com.tencent.mobileqq.matchfriend.reborn.utils.d;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.trpcprotocol.kuolie.signal_plaza_svr.signal_plaza_svr.SignalPlazaSvrPB$SignalInfo;
import com.tencent.trpcprotocol.kuolie.user_info.user_info.userInfo$MiniInfo;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ&\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0014J\b\u0010\n\u001a\u00020\u0006H\u0016J4\u0010\u0013\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u001a\u0010\u0011\u001a\u0016\u0012\u0012\u0012\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00020\u00020\u00100\u000f0\u0004H\u0016R\u001b\u0010\u0019\u001a\u00020\u00148BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/signal/square/delegate/QQStrangerSignalSquareItemAdapterDelegate;", "Lcom/tencent/biz/richframework/part/adapter/delegate/AbsItemAdapterDelegate;", "Lcom/tencent/trpcprotocol/kuolie/signal_plaza_svr/signal_plaza_svr/SignalPlazaSvrPB$SignalInfo;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "items", "", "position", "", "b", "getLayoutId", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/View;", "itemView", "Ljava/lang/Class;", "Lcom/tencent/biz/richframework/part/adapter/section/Section;", "sections", "", "initSection", "", "d", "Lkotlin/Lazy;", "getMyConstellation", "()Ljava/lang/String;", "myConstellation", "<init>", "()V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class QQStrangerSignalSquareItemAdapterDelegate extends AbsItemAdapterDelegate<SignalPlazaSvrPB$SignalInfo, SignalPlazaSvrPB$SignalInfo> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Lazy myConstellation;

    public QQStrangerSignalSquareItemAdapterDelegate() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.signal.square.delegate.QQStrangerSignalSquareItemAdapterDelegate$myConstellation$2
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                PBStringField pBStringField;
                Object a16 = d.f245469a.a("loginUserInfoKey");
                String str = null;
                userInfo$MiniInfo userinfo_miniinfo = a16 instanceof userInfo$MiniInfo ? (userInfo$MiniInfo) a16 : null;
                if (userinfo_miniinfo != null && (pBStringField = userinfo_miniinfo.constellation) != null) {
                    str = pBStringField.get();
                }
                return str == null ? "" : str;
            }
        });
        this.myConstellation = lazy;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate, com.tencent.biz.richframework.part.adapter.delegate.AbsListItemAdapterDelegate
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public boolean isForViewType(SignalPlazaSvrPB$SignalInfo item, List<SignalPlazaSvrPB$SignalInfo> items, int position) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(items, "items");
        return true;
    }

    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate
    public int getLayoutId() {
        return R.layout.cy_;
    }

    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate
    public void initSection(ViewGroup parent, View itemView, List<Class<? extends Section<SignalPlazaSvrPB$SignalInfo>>> sections) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(sections, "sections");
        sections.add(UserInfoSection.class);
        sections.add(com.tencent.mobileqq.matchfriend.reborn.content.signal.square.section.d.class);
        sections.add(ClickSection.class);
    }
}
