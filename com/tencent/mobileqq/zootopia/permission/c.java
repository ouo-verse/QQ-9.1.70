package com.tencent.mobileqq.zootopia.permission;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.widget.imageview.CircleBoarderImageView;
import com.tencent.mobileqq.zootopia.permission.c;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt__CharKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 72\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u000489:;B\u000f\u0012\u0006\u0010)\u001a\u00020&\u00a2\u0006\u0004\b5\u00106J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0014\u0010\r\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nJ\u000e\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000eJ\u0018\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u0018\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0013H\u0016J\b\u0010\u0019\u001a\u00020\u0013H\u0016J\u000e\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001aJ\u0010\u0010\u001f\u001a\u00020\u00132\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dJ\u0006\u0010 \u001a\u00020\bJ,\u0010%\u001a\u00020\b2\u0006\u0010!\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020\u00132\b\u0010\u001b\u001a\u0004\u0018\u00010\u001d2\b\u0010$\u001a\u0004\u0018\u00010#H\u0016R\u0014\u0010)\u001a\u00020&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u001e\u0010-\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0018\u00100\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0018\u00104\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103\u00a8\u0006<"}, d2 = {"Lcom/tencent/mobileqq/zootopia/permission/c;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/zootopia/permission/c$c;", "Lcom/tencent/mobileqq/avatar/listener/DecodeTaskCompletionListener;", "Lcom/tencent/mobileqq/zootopia/permission/c$b;", "data", "Lcom/tencent/mobileqq/widget/imageview/CircleBoarderImageView;", "avatarView", "", "r0", "", "Lhw4/j;", "friendInfoList", "setData", "Lcom/tencent/mobileqq/zootopia/permission/c$d;", "listener", "s0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "o0", "holder", "position", "m0", "getItemCount", "", "uin", "p0", "", "letter", "l0", "destroy", "remainingTasks", "type", "Landroid/graphics/Bitmap;", "avatar", "onDecodeTaskCompleted", "Landroid/content/Context;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/content/Context;", "context", "", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/List;", "list", "D", "Lcom/tencent/mobileqq/zootopia/permission/c$d;", "removeClickListener", "Lcom/tencent/mobileqq/app/face/IFaceDecoder;", "E", "Lcom/tencent/mobileqq/app/face/IFaceDecoder;", "avatarFaceDecoder", "<init>", "(Landroid/content/Context;)V", UserInfo.SEX_FEMALE, "a", "b", "c", "d", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class c extends RecyclerView.Adapter<C9114c> implements DecodeTaskCompletionListener {

    /* renamed from: C, reason: from kotlin metadata */
    private List<Friend> list;

    /* renamed from: D, reason: from kotlin metadata */
    private d removeClickListener;

    /* renamed from: E, reason: from kotlin metadata */
    private IFaceDecoder avatarFaceDecoder;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final Context context;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u00a2\u0006\u0004\b\u0016\u0010\u0017R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u0004\u0018\u00010\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/zootopia/permission/c$c;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/mobileqq/widget/imageview/CircleBoarderImageView;", "E", "Lcom/tencent/mobileqq/widget/imageview/CircleBoarderImageView;", "l", "()Lcom/tencent/mobileqq/widget/imageview/CircleBoarderImageView;", "avatar", "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Landroid/widget/TextView;", "name", "Landroid/widget/Button;", "G", "Landroid/widget/Button;", "o", "()Landroid/widget/Button;", "remove", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zootopia.permission.c$c, reason: collision with other inner class name */
    /* loaded from: classes35.dex */
    public static final class C9114c extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        private final CircleBoarderImageView avatar;

        /* renamed from: F, reason: from kotlin metadata */
        private final TextView name;

        /* renamed from: G, reason: from kotlin metadata */
        private final Button remove;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C9114c(View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.avatar = (CircleBoarderImageView) itemView.findViewById(R.id.pvy);
            this.name = (TextView) itemView.findViewById(R.id.pw5);
            this.remove = (Button) itemView.findViewById(R.id.pw7);
        }

        /* renamed from: l, reason: from getter */
        public final CircleBoarderImageView getAvatar() {
            return this.avatar;
        }

        /* renamed from: m, reason: from getter */
        public final TextView getName() {
            return this.name;
        }

        /* renamed from: o, reason: from getter */
        public final Button getRemove() {
            return this.remove;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/zootopia/permission/c$d;", "", "", "uin", "Landroid/view/View;", "view", "", "D8", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public interface d {
        void D8(long uin, View view);
    }

    public c(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        try {
            AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
            if ((waitAppRuntime instanceof AppInterface ? (AppInterface) waitAppRuntime : null) != null) {
                IFaceDecoder iQQAvatarService = ((IQQAvatarService) waitAppRuntime.getRuntimeService(IQQAvatarService.class, "")).getInstance((AppInterface) waitAppRuntime);
                this.avatarFaceDecoder = iQQAvatarService;
                if (iQQAvatarService != null) {
                    iQQAvatarService.setDecodeTaskCompletionListener(this);
                }
            }
        } catch (Exception e16) {
            QLog.e("FriendListAdapter", 1, "FriendListAdapter init avatarFaceDecoder throw:" + e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n0(c this$0, Friend data, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(data, "$data");
        d dVar = this$0.removeClickListener;
        if (dVar != null) {
            long uin = data.getUin();
            Intrinsics.checkNotNullExpressionValue(it, "it");
            dVar.D8(uin, it);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int q0(Friend friend, Friend friend2) {
        char firstChar = friend.getFirstChar();
        boolean z16 = false;
        if ('A' <= firstChar && firstChar < '[') {
            char firstChar2 = friend2.getFirstChar();
            if (!('A' <= firstChar2 && firstChar2 < '[')) {
                return -1;
            }
        }
        char firstChar3 = friend.getFirstChar();
        if (!('A' <= firstChar3 && firstChar3 < '[')) {
            char firstChar4 = friend2.getFirstChar();
            if ('A' <= firstChar4 && firstChar4 < '[') {
                z16 = true;
            }
            if (z16) {
                return 1;
            }
        }
        return Intrinsics.compare((int) friend.getFirstChar(), (int) friend2.getFirstChar());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r0(Friend data, CircleBoarderImageView avatarView) {
        IFaceDecoder iFaceDecoder = this.avatarFaceDecoder;
        Bitmap bitmapFromCache = iFaceDecoder != null ? iFaceDecoder.getBitmapFromCache(1, String.valueOf(data.getUin())) : null;
        if (bitmapFromCache != null) {
            avatarView.setImageBitmap(bitmapFromCache);
            return;
        }
        IFaceDecoder iFaceDecoder2 = this.avatarFaceDecoder;
        if (iFaceDecoder2 != null) {
            iFaceDecoder2.requestDecodeFace(String.valueOf(data.getUin()), 1, true);
        }
        avatarView.setImageResource(R.drawable.ik6);
    }

    public final void destroy() {
        IFaceDecoder iFaceDecoder = this.avatarFaceDecoder;
        if (iFaceDecoder != null) {
            iFaceDecoder.cancelPendingRequests();
        }
        IFaceDecoder iFaceDecoder2 = this.avatarFaceDecoder;
        if (iFaceDecoder2 != null) {
            iFaceDecoder2.destory();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        List<Friend> list = this.list;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: m0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(C9114c holder, int position) {
        final Friend friend;
        String name;
        Intrinsics.checkNotNullParameter(holder, "holder");
        List<Friend> list = this.list;
        if (list == null || (friend = list.get(position)) == null) {
            return;
        }
        TextView name2 = holder.getName();
        if (name2 != null) {
            if (TextUtils.isEmpty(friend.getName())) {
                name = String.valueOf(friend.getUin());
            } else {
                name = friend.getName();
            }
            name2.setText(name);
        }
        Button remove = holder.getRemove();
        if (remove != null) {
            remove.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zootopia.permission.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    c.n0(c.this, friend, view);
                }
            });
        }
        CircleBoarderImageView avatar = holder.getAvatar();
        if (avatar != null) {
            if (!TextUtils.isEmpty(friend.getAvatar())) {
                try {
                    URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                    obtain.mRequestWidth = avatar.getWidth();
                    obtain.mRequestHeight = avatar.getHeight();
                    obtain.mFailedDrawable = com.tencent.sqshow.zootopia.utils.q.b(R.drawable.ik6);
                    obtain.mLoadingDrawable = com.tencent.sqshow.zootopia.utils.q.b(R.drawable.ik6);
                    URLDrawable drawable = URLDrawable.getDrawable(friend.getAvatar(), obtain);
                    if (drawable != null && drawable.getStatus() == 1) {
                        avatar.setImageDrawable(drawable);
                    } else {
                        r0(friend, avatar);
                        if (drawable != null) {
                            drawable.setURLDrawableListener(new e(avatar, this, friend));
                        }
                    }
                    return;
                } catch (Exception e16) {
                    QLog.e("FriendListAdapter", 1, "set avatar throw e:" + e16);
                    return;
                }
            }
            r0(friend, avatar);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: o0, reason: merged with bridge method [inline-methods] */
    public C9114c onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.d7z, parent, false);
        Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
        return new C9114c(itemView);
    }

    public final void p0(long uin) {
        List<Friend> list = this.list;
        int i3 = -1;
        if (list != null) {
            int i16 = 0;
            for (Object obj : list) {
                int i17 = i16 + 1;
                if (i16 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                if (((Friend) obj).getUin() == uin) {
                    i3 = i16;
                }
                i16 = i17;
            }
        }
        List<Friend> list2 = this.list;
        if (list2 != null) {
            list2.remove(i3);
        }
        if (i3 >= 0) {
            notifyItemRemoved(i3);
        }
    }

    public final void s0(d listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.removeClickListener = listener;
    }

    public final void setData(List<hw4.j> friendInfoList) {
        int collectionSizeOrDefault;
        List<Friend> mutableList;
        String str;
        Intrinsics.checkNotNullParameter(friendInfoList, "friendInfoList");
        List<hw4.j> list = friendInfoList;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (hw4.j jVar : list) {
            String d16 = ChnToSpell.d(jVar.f406526b, 2);
            char charAt = d16 == null || d16.length() == 0 ? '#' : d16.charAt(0);
            long j3 = jVar.f406525a;
            String str2 = jVar.f406526b;
            if (str2 == null) {
                str = "";
            } else {
                Intrinsics.checkNotNullExpressionValue(str2, "it.nick ?: \"\"");
                str = str2;
            }
            String str3 = jVar.f406527c;
            if (str3 == null) {
                str3 = "";
            } else {
                Intrinsics.checkNotNullExpressionValue(str3, "it.image ?: \"\"");
            }
            arrayList.add(new Friend(j3, str, str3, Character.toUpperCase(charAt)));
        }
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList);
        CollectionsKt__MutableCollectionsJVMKt.sortWith(mutableList, new Comparator() { // from class: com.tencent.mobileqq.zootopia.permission.b
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int q06;
                q06 = c.q0((c.Friend) obj, (c.Friend) obj2);
                return q06;
            }
        });
        this.list = mutableList;
        notifyDataSetChanged();
    }

    @Override // com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener
    public void onDecodeTaskCompleted(int remainingTasks, int type, String uin, Bitmap avatar) {
        if (remainingTasks <= 0) {
            List<Friend> list = this.list;
            int i3 = -1;
            if (list != null) {
                int i16 = 0;
                for (Object obj : list) {
                    int i17 = i16 + 1;
                    if (i16 < 0) {
                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                    }
                    if (Intrinsics.areEqual(String.valueOf(((Friend) obj).getUin()), uin)) {
                        i3 = i16;
                    }
                    i16 = i17;
                }
            }
            if (i3 >= 0) {
                notifyItemChanged(i3);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\f\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0013\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0010\u001a\u0004\b\n\u0010\u0012R\u0017\u0010\u0018\u001a\u00020\u00158\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0016\u001a\u0004\b\u000f\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/zootopia/permission/c$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "J", "d", "()J", "uin", "b", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "name", "avatar", "", BdhLogUtil.LogTag.Tag_Conn, "()C", "firstChar", "<init>", "(JLjava/lang/String;Ljava/lang/String;C)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zootopia.permission.c$b, reason: from toString */
    /* loaded from: classes35.dex */
    public static final /* data */ class Friend {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final long uin;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final String name;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private final String avatar;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final char firstChar;

        public Friend(long j3, String name, String str, char c16) {
            Intrinsics.checkNotNullParameter(name, "name");
            this.uin = j3;
            this.name = name;
            this.avatar = str;
            this.firstChar = c16;
        }

        /* renamed from: a, reason: from getter */
        public final String getAvatar() {
            return this.avatar;
        }

        /* renamed from: b, reason: from getter */
        public final char getFirstChar() {
            return this.firstChar;
        }

        /* renamed from: c, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* renamed from: d, reason: from getter */
        public final long getUin() {
            return this.uin;
        }

        public int hashCode() {
            int a16 = ((com.tencent.mobileqq.vas.banner.c.a(this.uin) * 31) + this.name.hashCode()) * 31;
            String str = this.avatar;
            return ((a16 + (str == null ? 0 : str.hashCode())) * 31) + this.firstChar;
        }

        public String toString() {
            return "Friend(uin=" + this.uin + ", name=" + this.name + ", avatar=" + this.avatar + ", firstChar=" + this.firstChar + ")";
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Friend)) {
                return false;
            }
            Friend friend = (Friend) other;
            return this.uin == friend.uin && Intrinsics.areEqual(this.name, friend.name) && Intrinsics.areEqual(this.avatar, friend.avatar) && this.firstChar == friend.firstChar;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x0003, code lost:
    
        r11 = kotlin.text.StringsKt___StringsKt.firstOrNull(r11);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int l0(String letter) {
        Character firstOrNull;
        boolean equals;
        if (letter != null && firstOrNull != null) {
            char charValue = firstOrNull.charValue();
            List<Friend> list = this.list;
            if (list != null) {
                int i3 = 0;
                for (Object obj : list) {
                    int i16 = i3 + 1;
                    if (i3 < 0) {
                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                    }
                    Friend friend = (Friend) obj;
                    if ('A' <= charValue && charValue < '[') {
                        equals = CharsKt__CharKt.equals(friend.getFirstChar(), charValue, true);
                        if (equals) {
                            return i3;
                        }
                    } else {
                        char firstChar = friend.getFirstChar();
                        if (!('A' <= firstChar && firstChar < '[')) {
                            return i3;
                        }
                    }
                    i3 = i16;
                }
            }
        }
        return -1;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\u000b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\nH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/zootopia/permission/c$e", "Lcom/tencent/image/URLDrawable$URLDrawableListener;", "Lcom/tencent/image/URLDrawable;", "p0", "", "onLoadSuccessed", "", "p1", "onLoadFialed", "onLoadCanceled", "", "onLoadProgressed", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class e implements URLDrawable.URLDrawableListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ CircleBoarderImageView f328643d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ c f328644e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Friend f328645f;

        e(CircleBoarderImageView circleBoarderImageView, c cVar, Friend friend) {
            this.f328643d = circleBoarderImageView;
            this.f328644e = cVar;
            this.f328645f = friend;
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadCanceled(URLDrawable p06) {
            this.f328644e.r0(this.f328645f, this.f328643d);
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadFialed(URLDrawable p06, Throwable p16) {
            this.f328644e.r0(this.f328645f, this.f328643d);
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadSuccessed(URLDrawable p06) {
            this.f328643d.setImageDrawable(p06);
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadProgressed(URLDrawable p06, int p16) {
        }
    }
}
