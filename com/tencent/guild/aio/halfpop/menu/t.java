package com.tencent.guild.aio.halfpop.menu;

import android.content.Context;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aio.data.AIOParam;
import com.tencent.guild.aio.util.ex.FromScene;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qqnt.msg.MsgExtKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001#B\u000f\u0012\u0006\u0010 \u001a\u00020\u001b\u00a2\u0006\u0004\b!\u0010\"J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\n\u001a\u00020\bJ\u0006\u0010\u000b\u001a\u00020\u0006J\u0006\u0010\f\u001a\u00020\u0006J\u0006\u0010\r\u001a\u00020\u0006J\u0006\u0010\u000e\u001a\u00020\u0006J\u0006\u0010\u000f\u001a\u00020\u0006J\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010J\u0006\u0010\u0012\u001a\u00020\u0006J\u0006\u0010\u0013\u001a\u00020\u0006J\u0018\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0016\u0010\u001a\u001a\u00020\u00042\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0016R\u0017\u0010 \u001a\u00020\u001b8\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\u00a8\u0006$"}, d2 = {"Lcom/tencent/guild/aio/halfpop/menu/t;", "Lcom/tencent/guild/aio/halfpop/menu/a;", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "data", "", ReportConstant.COSTREPORT_PREFIX, "", "t", "", "u", "w", "B", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "D", "G", "Landroid/content/Context;", "v", BdhLogUtil.LogTag.Tag_Conn, "y", "Landroid/view/View;", "view", UserInfo.SEX_FEMALE, "", "", "configType", "E", "Lcom/tencent/guild/aio/halfpop/menu/t$a;", "f", "Lcom/tencent/guild/aio/halfpop/menu/t$a;", HippyTKDListViewAdapter.X, "()Lcom/tencent/guild/aio/halfpop/menu/t$a;", "itemInfo", "<init>", "(Lcom/tencent/guild/aio/halfpop/menu/t$a;)V", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public class t extends a<GuildMsgItem> {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ItemData itemInfo;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\t\u0010\f\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/guild/aio/halfpop/menu/t$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "b", "()I", "leftDrawableRes", "itemTitleRes", "<init>", "(II)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.guild.aio.halfpop.menu.t$a, reason: from toString */
    /* loaded from: classes6.dex */
    public static final /* data */ class ItemData {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final int leftDrawableRes;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final int itemTitleRes;

        public ItemData(int i3, int i16) {
            this.leftDrawableRes = i3;
            this.itemTitleRes = i16;
        }

        /* renamed from: a, reason: from getter */
        public final int getItemTitleRes() {
            return this.itemTitleRes;
        }

        /* renamed from: b, reason: from getter */
        public final int getLeftDrawableRes() {
            return this.leftDrawableRes;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ItemData)) {
                return false;
            }
            ItemData itemData = (ItemData) other;
            if (this.leftDrawableRes == itemData.leftDrawableRes && this.itemTitleRes == itemData.itemTitleRes) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.leftDrawableRes * 31) + this.itemTitleRes;
        }

        @NotNull
        public String toString() {
            return "ItemData(leftDrawableRes=" + this.leftDrawableRes + ", itemTitleRes=" + this.itemTitleRes + ")";
        }
    }

    public t(@NotNull ItemData itemInfo) {
        Intrinsics.checkNotNullParameter(itemInfo, "itemInfo");
        this.itemInfo = itemInfo;
    }

    public final boolean A() {
        if (com.tencent.guild.aio.util.ex.a.d(h()) == FromScene.DIRECT.ordinal()) {
            return true;
        }
        return false;
    }

    public final boolean B() {
        return Intrinsics.areEqual(h().g().n(), com.tencent.guild.aio.factory.a.class.getName());
    }

    public final boolean C() {
        return Intrinsics.areEqual(h().g().n(), qn0.a.class.getName());
    }

    public final boolean D() {
        return MsgExtKt.U(i().getMsgRecord());
    }

    public void E(@NotNull List<Integer> configType) {
        Intrinsics.checkNotNullParameter(configType, "configType");
    }

    /* renamed from: F */
    public void b(@NotNull View view, @NotNull GuildMsgItem data) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(data, "data");
        super.b(view, data);
        j().o8();
    }

    public final boolean G() {
        return MsgExtKt.R(i().getMsgRecord());
    }

    @Override // com.tencent.guild.aio.halfpop.menu.a
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public void o(@NotNull GuildMsgItem data) {
        Intrinsics.checkNotNullParameter(data, "data");
        super.o(data);
        p().f441953b.setBackgroundResource(this.itemInfo.getLeftDrawableRes());
        p().f441955d.setText(this.itemInfo.getItemTitleRes());
    }

    @Override // com.tencent.guild.aio.halfpop.menu.b, com.tencent.guild.aio.halfpop.menu.n
    /* renamed from: t */
    public boolean a(@NotNull GuildMsgItem data) {
        Intrinsics.checkNotNullParameter(data, "data");
        ArrayList arrayList = new ArrayList();
        E(arrayList);
        if (arrayList.size() > 0) {
            return arrayList.contains(Integer.valueOf(data.getViewType()));
        }
        return true;
    }

    @NotNull
    public final String u() {
        AIOParam g16 = h().g();
        Intrinsics.checkNotNullExpressionValue(g16, "aioContext.aioParam");
        return com.tencent.guild.aio.util.a.b(g16);
    }

    @Nullable
    public final Context v() {
        return h().c().getContext();
    }

    @NotNull
    public final String w() {
        AIOParam g16 = h().g();
        Intrinsics.checkNotNullExpressionValue(g16, "aioContext.aioParam");
        return com.tencent.guild.aio.util.a.g(g16);
    }

    @NotNull
    /* renamed from: x, reason: from getter */
    public final ItemData getItemInfo() {
        return this.itemInfo;
    }

    public final boolean y() {
        AIOParam g16 = h().g();
        Intrinsics.checkNotNullExpressionValue(g16, "aioContext.aioParam");
        Integer d16 = com.tencent.guild.aio.util.a.d(g16);
        if (d16 != null && d16.intValue() == 6) {
            return true;
        }
        return false;
    }

    public final boolean z() {
        return Intrinsics.areEqual(h().g().n(), hn0.a.class.getName());
    }
}
