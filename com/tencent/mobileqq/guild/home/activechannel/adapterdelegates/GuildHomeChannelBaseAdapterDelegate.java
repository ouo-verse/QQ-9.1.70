package com.tencent.mobileqq.guild.home.activechannel.adapterdelegates;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import so1.h;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\b&\u0018\u0000 \u0018*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0004*\u00020\u00032\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00060\u0005:\u0002\u0019\u001aB\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u001e\u0010\u000b\u001a\u00020\n2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00062\u0006\u0010\t\u001a\u00020\bH\u0014J\u0018\u0010\r\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\bH$J6\u0010\u0012\u001a\u00020\u00112\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u00032\u000e\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u0006H\u0014J7\u0010\u0014\u001a\u00020\u00112\u0006\u0010\f\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00028\u00012\u000e\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u00062\u0006\u0010\u0013\u001a\u00020\bH\u0014\u00a2\u0006\u0004\b\u0014\u0010\u0015\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/guild/home/activechannel/adapterdelegates/GuildHomeChannelBaseAdapterDelegate;", "Lso1/h;", "T", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "VH", "Lcom/tencent/mobileqq/guild/widget/adapterdelegates/b;", "", "items", "", "position", "", "j", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "k", "holder", "", "payloads", "", "l", com.tencent.luggage.wxa.c8.c.G, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Lso1/h;Landroidx/recyclerview/widget/RecyclerView$ViewHolder;Ljava/util/List;I)V", "<init>", "()V", "d", "a", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public abstract class GuildHomeChannelBaseAdapterDelegate<T extends so1.h, VH extends RecyclerView.ViewHolder> extends com.tencent.mobileqq.guild.widget.adapterdelegates.b<List<? extends T>> {

    /* compiled from: P */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u001e\u00a2\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0007H\u0016J(\u0010\u0012\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0010H\u0004J\b\u0010\u0013\u001a\u00020\u0007H\u0004J\b\u0010\u0014\u001a\u00020\u0005H&J\b\u0010\u0015\u001a\u00020\u0005H&J\b\u0010\u0016\u001a\u00020\u0003H&R\u0016\u0010\u0019\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001b\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u0018\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/guild/home/activechannel/adapterdelegates/GuildHomeChannelBaseAdapterDelegate$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/mobileqq/guild/widget/adapterdelegates/n;", "", "from", "", "o", "", "resumed", "p", NodeProps.VISIBLE, "onVisibleChanged", "", "noMemberMaxLimit", "memberMax", "memberCount", "Landroid/widget/TextView;", "view", "r", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, ReportConstant.COSTREPORT_PREFIX, "t", "getTag", "E", "Z", "isAttachToWindow", UserInfo.SEX_FEMALE, "isSubChannelCardVisible", "G", "isResumed", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static abstract class a extends RecyclerView.ViewHolder implements com.tencent.mobileqq.guild.widget.adapterdelegates.n {

        /* renamed from: E, reason: from kotlin metadata */
        private boolean isAttachToWindow;

        /* renamed from: F, reason: from kotlin metadata */
        private boolean isSubChannelCardVisible;

        /* renamed from: G, reason: from kotlin metadata */
        private boolean isResumed;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            this.isSubChannelCardVisible = true;
            this.isResumed = true;
        }

        private final void o(String from) {
            Logger logger = Logger.f235387a;
            String tag = getTag();
            if (QLog.isColorLevel()) {
                logger.d().d(tag, 1, "onVisibleChanged isAttachToWindow:" + this.isAttachToWindow + " isSubChannelCardVisible:" + this.isSubChannelCardVisible + " isResumed:" + this.isResumed + " from:" + from + " id:" + System.identityHashCode(this));
            }
            if (q()) {
                s();
            } else {
                t();
            }
        }

        @NotNull
        public abstract String getTag();

        @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.n
        public void onVisibleChanged(boolean visible) {
            this.isAttachToWindow = visible;
            o("onVisibleChanged");
        }

        public final void p(boolean resumed) {
            if (resumed == this.isResumed) {
                return;
            }
            this.isResumed = resumed;
            o("changePageResumed");
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public final boolean q() {
            if (this.isResumed && this.isSubChannelCardVisible && this.isAttachToWindow) {
                return true;
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public final void r(int noMemberMaxLimit, int memberMax, int memberCount, @NotNull TextView view) {
            Intrinsics.checkNotNullParameter(view, "view");
            if (noMemberMaxLimit != 1 && memberMax != 0) {
                view.setText(memberCount + "/" + memberMax);
                return;
            }
            if (memberCount > 999) {
                view.setText("999+");
            } else {
                view.setText(String.valueOf(memberCount));
            }
        }

        public abstract void s();

        public abstract void t();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.b
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public boolean a(@NotNull List<? extends T> items, int position) {
        Intrinsics.checkNotNullParameter(items, "items");
        return k(items.get(position), position);
    }

    protected abstract boolean k(@NotNull so1.h item, int position);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.b
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public void c(@NotNull List<? extends T> items, int position, @NotNull RecyclerView.ViewHolder holder, @NotNull List<? extends Object> payloads) {
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        m(items.get(position), holder, payloads, position);
    }

    protected abstract void m(@NotNull T item, @NotNull VH holder, @NotNull List<? extends Object> payloads, int pos);
}
