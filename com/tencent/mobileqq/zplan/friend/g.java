package com.tencent.mobileqq.zplan.friend;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 #2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002$%B+\u0012\u0006\u0010 \u001a\u00020\u001f\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u0012\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\n0\u0017\u00a2\u0006\u0004\b!\u0010\"J\u0010\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003J\u0016\u0010\u000b\u001a\u00020\n2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0007J\u0018\u0010\u000f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0005H\u0016J\u0018\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0005H\u0016R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R \u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\n0\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\"\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001d\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/zplan/friend/g;", "Lcom/tencent/mobileqq/zplan/friend/b;", "Lcom/tencent/mobileqq/zplan/friend/g$b;", "", "letter", "", "n0", "", "Lcom/tencent/mobileqq/zplan/friend/c;", "selectList", "", "r0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "q0", "holder", "position", "o0", "Landroid/content/Context;", "D", "Landroid/content/Context;", "context", "Lkotlin/Function1;", "E", "Lkotlin/jvm/functions/Function1;", "itemClickListener", "", UserInfo.SEX_FEMALE, "Ljava/util/Map;", "selectMap", "Lcom/tencent/mobileqq/zplan/friend/e;", "friendItemBinder", "<init>", "(Lcom/tencent/mobileqq/zplan/friend/e;Landroid/content/Context;Lkotlin/jvm/functions/Function1;)V", "G", "a", "b", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class g extends com.tencent.mobileqq.zplan.friend.b<b> {

    /* renamed from: D, reason: from kotlin metadata */
    private final Context context;

    /* renamed from: E, reason: from kotlin metadata */
    private final Function1<String, Unit> itemClickListener;

    /* renamed from: F, reason: from kotlin metadata */
    private Map<String, Integer> selectMap;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u00a2\u0006\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\r\u001a\u0004\u0018\u00010\b8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0010\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u0017\u0010\u0013\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u0012\u0010\f\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/zplan/friend/g$b;", "Lcom/tencent/mobileqq/zplan/friend/a;", "Landroid/widget/ImageView;", "G", "Landroid/widget/ImageView;", "l", "()Landroid/widget/ImageView;", "avatar", "Landroid/widget/TextView;", "H", "Landroid/widget/TextView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Landroid/widget/TextView;", "name", "I", "o", "profile", "J", "p", "selectIndicator", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b extends a {

        /* renamed from: G, reason: from kotlin metadata */
        private final ImageView avatar;

        /* renamed from: H, reason: from kotlin metadata */
        private final TextView name;

        /* renamed from: I, reason: from kotlin metadata */
        private final ImageView profile;

        /* renamed from: J, reason: from kotlin metadata */
        private final TextView selectIndicator;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.avatar = (ImageView) itemView.findViewById(R.id.q49);
            this.name = (TextView) itemView.findViewById(R.id.qug);
            View findViewById = itemView.findViewById(R.id.q4_);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.iv_user_profile_image)");
            this.profile = (ImageView) findViewById;
            View findViewById2 = itemView.findViewById(R.id.qu7);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.tv_select_indicator)");
            this.selectIndicator = (TextView) findViewById2;
        }

        @Override // com.tencent.mobileqq.zplan.friend.a
        /* renamed from: l, reason: from getter */
        public ImageView getAvatar() {
            return this.avatar;
        }

        @Override // com.tencent.mobileqq.zplan.friend.a
        /* renamed from: m, reason: from getter */
        public TextView getName() {
            return this.name;
        }

        /* renamed from: o, reason: from getter */
        public final ImageView getProfile() {
            return this.profile;
        }

        /* renamed from: p, reason: from getter */
        public final TextView getSelectIndicator() {
            return this.selectIndicator;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public g(e friendItemBinder, Context context, Function1<? super String, Unit> itemClickListener) {
        super(friendItemBinder);
        Map<String, Integer> emptyMap;
        Intrinsics.checkNotNullParameter(friendItemBinder, "friendItemBinder");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(itemClickListener, "itemClickListener");
        this.context = context;
        this.itemClickListener = itemClickListener;
        emptyMap = MapsKt__MapsKt.emptyMap();
        this.selectMap = emptyMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p0(g this$0, FriendInfo friendInfo, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(friendInfo, "$friendInfo");
        this$0.itemClickListener.invoke(friendInfo.getUin());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: o0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(b holder, int position) {
        String str;
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.j0(holder, position);
        final FriendInfo friendInfo = i0().get(position);
        Integer num = this.selectMap.get(friendInfo.getUin());
        int intValue = num != null ? num.intValue() : 0;
        holder.getSelectIndicator().setSelected(intValue > 0);
        TextView selectIndicator = holder.getSelectIndicator();
        if (intValue > 0) {
            str = String.valueOf(intValue);
        } else {
            str = "";
        }
        selectIndicator.setText(str);
        String profileUrl = friendInfo.getProfileUrl();
        if (profileUrl == null || profileUrl.length() == 0) {
            holder.getProfile().setImageDrawable(null);
        } else {
            holder.getProfile().setImageDrawable(URLDrawable.getDrawable(friendInfo.getProfileUrl(), URLDrawable.URLDrawableOptions.obtain()));
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.friend.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                g.p0(g.this, friendInfo, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: q0, reason: merged with bridge method [inline-methods] */
    public b onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(this.context).inflate(R.layout.dhg, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(context)\n          \u2026iend_item, parent, false)");
        return new b(inflate);
    }

    public final void r0(List<FriendInfo> selectList) {
        Intrinsics.checkNotNullParameter(selectList, "selectList");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int i3 = 0;
        for (Object obj : selectList) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            linkedHashMap.put(((FriendInfo) obj).getUin(), Integer.valueOf(i16));
            i3 = i16;
        }
        this.selectMap = linkedHashMap;
        notifyDataSetChanged();
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x0003, code lost:
    
        r5 = kotlin.text.StringsKt___StringsKt.firstOrNull(r5);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int n0(String letter) {
        Character firstOrNull;
        if (letter != null && firstOrNull != null) {
            char charValue = firstOrNull.charValue();
            int size = i0().size();
            for (int i3 = 0; i3 < size; i3++) {
                Character firstChar = i0().get(i3).getFirstChar();
                if (firstChar != null && firstChar.charValue() == charValue) {
                    return i3;
                }
            }
        }
        return -1;
    }
}
