package com.tencent.mobileqq.guild.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.IGuildQCircleAvatarApi;
import com.tencent.mobileqq.guild.avatar.GuildUserAvatarRepository;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 #2\u00020\u0001:\u0001$B\u001d\b\u0007\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001f\u00a2\u0006\u0004\b!\u0010\"J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u001a\u0010\b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0014J\b\u0010\f\u001a\u00020\u0004H\u0014R\u0016\u0010\u0006\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\rR\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\rR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R*\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00028\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\r\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/guild/widget/GuildUserAvatarPendantView;", "Landroid/widget/ImageView;", "", "avatarPendant", "", "d", "tinyId", "e", "setPendantTinyId", "url", "setUrl", NodeProps.ON_ATTACHED_TO_WINDOW, NodeProps.ON_DETACHED_FROM_WINDOW, "Ljava/lang/String;", "", "f", "Z", "needUpdateByTinyIdAfterAttach", "log", tl.h.F, "c", "()Ljava/lang/String;", "setLogTag", "(Ljava/lang/String;)V", "logTag", "Lcom/tencent/mobileqq/guild/avatar/d;", "i", "Lcom/tencent/mobileqq/guild/avatar/d;", "urlChangeListener", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes14.dex */
public final class GuildUserAvatarPendantView extends ImageView {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String tinyId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String avatarPendant;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean needUpdateByTinyIdAfterAttach;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String logTag;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.guild.avatar.d urlChangeListener;

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/guild/widget/GuildUserAvatarPendantView$b", "Lcom/tencent/mobileqq/guild/avatar/d;", "", "tinyId", "pendantAvatarMeta", "", "doOnUrlChange", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b implements com.tencent.mobileqq.guild.avatar.d {
        b() {
        }

        @Override // com.tencent.mobileqq.guild.avatar.d
        public void doOnUrlChange(@NotNull String tinyId, @NotNull String pendantAvatarMeta) {
            Intrinsics.checkNotNullParameter(tinyId, "tinyId");
            Intrinsics.checkNotNullParameter(pendantAvatarMeta, "pendantAvatarMeta");
            if (TextUtils.equals(GuildUserAvatarPendantView.this.tinyId, tinyId)) {
                GuildUserAvatarPendantView.this.e(tinyId);
                Logger logger = Logger.f235387a;
                String logTag = GuildUserAvatarPendantView.this.getLogTag();
                if (QLog.isColorLevel()) {
                    logger.d().d(logTag, 2, "[doOnUrlChange] tinyId:" + tinyId);
                }
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildUserAvatarPendantView(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void d(String avatarPendant) {
        setTag(R.id.whs, 0);
        if (TextUtils.isEmpty(avatarPendant)) {
            QLog.w(this.logTag, 1, "[loadImageByAvatarPendant] avatarPendant empty");
            setImageDrawable(null);
            return;
        }
        ((IGuildQCircleAvatarApi) QRoute.api(IGuildQCircleAvatarApi.class)).loadPendantByAvatarPendant(avatarPendant, this);
        Logger logger = Logger.f235387a;
        String str = this.logTag;
        if (QLog.isDevelopLevel()) {
            Log.d(str, "[loadImageByAvatarPendant] avatarPendant:" + avatarPendant + ", hashcode:" + hashCode());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e(String tinyId) {
        setTag(R.id.whs, 0);
        if (TextUtils.isEmpty(tinyId)) {
            QLog.w(this.logTag, 1, "[loadPendantByTinyId] tinyId empty");
            setImageDrawable(null);
            return;
        }
        ((IGuildQCircleAvatarApi) QRoute.api(IGuildQCircleAvatarApi.class)).loadPendantByTinyId(tinyId, this);
        Logger logger = Logger.f235387a;
        String str = this.logTag;
        if (QLog.isDevelopLevel()) {
            Log.d(str, "[loadPendantByTinyId] tinyId:" + tinyId + ", hashcode:" + hashCode());
        }
    }

    public static /* synthetic */ void setPendantTinyId$default(GuildUserAvatarPendantView guildUserAvatarPendantView, String str, String str2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str2 = null;
        }
        guildUserAvatarPendantView.setPendantTinyId(str, str2);
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getLogTag() {
        return this.logTag;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        boolean z16;
        super.onAttachedToWindow();
        GuildUserAvatarRepository.e(this.urlChangeListener);
        boolean z17 = true;
        if (this.avatarPendant.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            if (!Intrinsics.areEqual(getTag(R.id.whs), (Object) 1)) {
                d(this.avatarPendant);
                return;
            }
            return;
        }
        if (this.tinyId.length() <= 0) {
            z17 = false;
        }
        if (z17 && this.needUpdateByTinyIdAfterAttach) {
            this.needUpdateByTinyIdAfterAttach = false;
            e(this.tinyId);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        GuildUserAvatarRepository.j(this.urlChangeListener);
        this.needUpdateByTinyIdAfterAttach = true;
    }

    public final void setLogTag(@NotNull String log) {
        Intrinsics.checkNotNullParameter(log, "log");
        this.logTag = "Guild.user.GuildUserAvatarPendantView" + log;
    }

    public final void setPendantTinyId(@NotNull String tinyId, @Nullable String avatarPendant) {
        String str;
        boolean z16;
        Intrinsics.checkNotNullParameter(tinyId, "tinyId");
        this.tinyId = tinyId;
        if (avatarPendant == null) {
            str = "";
        } else {
            str = avatarPendant;
        }
        this.avatarPendant = str;
        boolean z17 = false;
        if (avatarPendant != null && avatarPendant.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            d(avatarPendant);
        } else {
            if (tinyId.length() == 0) {
                z17 = true;
            }
            if (!z17) {
                e(tinyId);
            } else {
                QLog.w(this.logTag, 1, "[loadPendantByTinyId] tinyId and avatarPendant empty");
                setImageDrawable(null);
            }
        }
        Logger logger = Logger.f235387a;
        String str2 = this.logTag;
        if (QLog.isDevelopLevel()) {
            Log.d(str2, "[setPendantTinyId] tinyId:" + tinyId + ", avatarPendant:" + avatarPendant);
        }
    }

    public final void setUrl(@NotNull String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        ((IGuildQCircleAvatarApi) QRoute.api(IGuildQCircleAvatarApi.class)).loadPendantByUrl(url, this);
    }

    public /* synthetic */ GuildUserAvatarPendantView(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildUserAvatarPendantView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.tinyId = "";
        this.avatarPendant = "";
        this.logTag = "Guild.user.GuildUserAvatarPendantView";
        this.urlChangeListener = new b();
    }
}
