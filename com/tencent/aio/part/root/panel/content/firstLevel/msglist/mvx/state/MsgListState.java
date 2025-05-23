package com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.state;

import android.os.Bundle;
import com.tencent.aio.base.mvi.part.MsgListUiState;
import com.tencent.aio.data.msglist.a;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qfix.redirect.utils.ReflectUtils;
import com.tencent.mvi.base.route.h;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\u0005\b\u0016\u0018\u0000  2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001 B7\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\u000e\b\u0002\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00020\u001c\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0004\u001a\u00020\u0000H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016R(\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0018\n\u0004\b\b\u0010\t\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\u00a8\u0006!"}, d2 = {"Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/state/MsgListState;", "Ljava/util/LinkedList;", "Lcom/tencent/aio/data/msglist/a;", "Lcom/tencent/aio/base/mvi/part/MsgListUiState;", "clone", "", "toString", "", "focusIndex", "J", "getFocusIndex", "()J", "setFocusIndex", "(J)V", "getFocusIndex$annotations", "()V", "", "updateType", "I", "getUpdateType", "()I", "setUpdateType", "(I)V", "Landroid/os/Bundle;", "extra", "Landroid/os/Bundle;", "getExtra", "()Landroid/os/Bundle;", "", "list", "<init>", "(JLjava/util/Collection;ILandroid/os/Bundle;)V", "Companion", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public class MsgListState extends LinkedList<a> implements MsgListUiState {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    public static final long FOCUS_BOTTOM = -1;
    public static final long FOCUS_HEAD = -2;
    public static final long FOCUS_USER = -3;

    @Nullable
    private final Bundle extra;
    private long focusIndex;
    private int updateType;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u0007B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/state/MsgListState$Companion;", "", "()V", "FOCUS_BOTTOM", "", "FOCUS_HEAD", "FOCUS_USER", "UpdateType", "sdk_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes3.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        /* compiled from: P */
        @Target({ElementType.PARAMETER, ElementType.TYPE_USE})
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/state/MsgListState$Companion$UpdateType;", "", "Companion", "a", "sdk_debug"}, k = 1, mv = {1, 4, 2})
        @kotlin.annotation.Target(allowedTargets = {AnnotationTarget.PROPERTY, AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.TYPE})
        @Retention(RetentionPolicy.SOURCE)
        @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
        /* loaded from: classes3.dex */
        public @interface UpdateType {
            public static final IPatchRedirector $redirector_ = null;

            /* renamed from: Companion, reason: from kotlin metadata */
            @NotNull
            public static final Companion INSTANCE;
            public static final int UPDATE_ALL = 3;
            public static final int UPDATE_DISABLE_LOAD_MORE = 128;
            public static final int UPDATE_DISABLE_REFRESH = 64;
            public static final int UPDATE_ENABLE_LOAD_MORE = 32;
            public static final int UPDATE_ENABLE_REFRESH = 16;
            public static final int UPDATE_HIDE_LOAD_MORE = 8;
            public static final int UPDATE_HIDE_REFRESH = 4;
            public static final int UPDATE_INDEX = 2;
            public static final int UPDATE_LIST = 1;

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\r\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0016\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0000\u00a2\u0006\u0004\b\b\u0010\tJ\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002H\u0000\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/state/MsgListState$Companion$UpdateType$a;", "", "", "targetType", "curType", "", "a", "", "c", "(I)Ljava/lang/CharSequence;", "b", "(I)Z", "<init>", "()V", "sdk_debug"}, k = 1, mv = {1, 4, 2})
            /* renamed from: com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.state.MsgListState$Companion$UpdateType$a, reason: from kotlin metadata */
            /* loaded from: classes3.dex */
            public static final class Companion {
                static IPatchRedirector $redirector_;

                /* renamed from: a, reason: collision with root package name */
                static final /* synthetic */ Companion f69568a;

                static {
                    IPatchRedirector redirector = PatchRedirectCenter.getRedirector(47116);
                    $redirector_ = redirector;
                    if (redirector != null && redirector.hasPatch((short) 5)) {
                        redirector.redirect((short) 5);
                    } else {
                        f69568a = new Companion();
                    }
                }

                Companion() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                        iPatchRedirector.redirect((short) 4, (Object) this);
                    }
                }

                public final boolean a(int targetType, int curType) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        return ((Boolean) iPatchRedirector.redirect((short) 1, this, Integer.valueOf(targetType), Integer.valueOf(curType))).booleanValue();
                    }
                    if ((targetType & curType) == 0) {
                        return false;
                    }
                    return true;
                }

                public final boolean b(int targetType) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                        return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, targetType)).booleanValue();
                    }
                    if (!a(targetType, 4) && !a(targetType, 8)) {
                        return false;
                    }
                    return true;
                }

                @NotNull
                public final CharSequence c(int targetType) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        return (CharSequence) iPatchRedirector.redirect((short) 2, (Object) this, targetType);
                    }
                    StringBuilder sb5 = new StringBuilder("\n");
                    if (a(targetType, 1)) {
                        sb5.append("updateList\n");
                    }
                    if (a(targetType, 2)) {
                        sb5.append("location\n");
                    }
                    if (a(targetType, 4)) {
                        sb5.append("hideRefresh\n");
                    }
                    if (a(targetType, 8)) {
                        sb5.append("hideLoadMore\n");
                    }
                    if (a(targetType, 16)) {
                        sb5.append("enableRefresh\n");
                    }
                    if (a(targetType, 32)) {
                        sb5.append("enableLoadMore\n");
                    }
                    if (a(targetType, 64)) {
                        sb5.append("disableRefresh\n");
                    }
                    if (a(targetType, 128)) {
                        sb5.append("disableLoadMore\n");
                    }
                    if (a(targetType, 3)) {
                        sb5.append("UPDATE_ALL\n");
                    }
                    return sb5;
                }
            }

            static {
                ReflectUtils.setStaticField(PatchRedirectCenter.getRedirector(47117), (Class<?>) UpdateType.class, "$redirector_");
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1);
                } else {
                    INSTANCE = Companion.f69568a;
                }
            }
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(47119);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public MsgListState() {
        this(0L, null, 0, null, 15, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 10)) {
            return;
        }
        iPatchRedirector.redirect((short) 10, (Object) this);
    }

    public /* bridge */ boolean contains(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 14)) ? super.contains((Object) aVar) : ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this, (Object) aVar)).booleanValue();
    }

    @Override // com.tencent.mvi.base.route.i
    @androidx.annotation.Nullable
    public /* bridge */ /* synthetic */ String eventName() {
        return h.a(this);
    }

    @Nullable
    public final Bundle getExtra() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Bundle) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.extra;
    }

    public final long getFocusIndex() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Long) iPatchRedirector.redirect((short) 3, (Object) this)).longValue();
        }
        return this.focusIndex;
    }

    public /* bridge */ int getSize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Integer) iPatchRedirector.redirect((short) 22, (Object) this)).intValue();
        }
        return super.size();
    }

    public final int getUpdateType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.updateType;
    }

    public /* bridge */ int indexOf(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 18)) ? super.indexOf((Object) aVar) : ((Integer) iPatchRedirector.redirect((short) 18, (Object) this, (Object) aVar)).intValue();
    }

    public /* bridge */ int lastIndexOf(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 20)) ? super.lastIndexOf((Object) aVar) : ((Integer) iPatchRedirector.redirect((short) 20, (Object) this, (Object) aVar)).intValue();
    }

    @Override // java.util.LinkedList, java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
    public final /* bridge */ a remove(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 17)) ? removeAt(i3) : (a) iPatchRedirector.redirect((short) 17, (Object) this, i3);
    }

    public /* bridge */ a removeAt(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (a) iPatchRedirector.redirect((short) 16, (Object) this, i3);
        }
        return (a) super.remove(i3);
    }

    public final void setFocusIndex(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, j3);
        } else {
            this.focusIndex = j3;
        }
    }

    public final void setUpdateType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
        } else {
            this.updateType = i3;
        }
    }

    @Override // java.util.LinkedList, java.util.AbstractCollection, java.util.Collection, java.util.List, java.util.Deque
    public final /* bridge */ int size() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Integer) iPatchRedirector.redirect((short) 23, (Object) this)).intValue();
        }
        return getSize();
    }

    @Override // java.util.AbstractCollection
    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "MsgListState(focusIndex=" + this.focusIndex + ", updateType=" + this.updateType + ')';
    }

    public /* synthetic */ MsgListState(long j3, Collection collection, int i3, Bundle bundle, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? -1L : j3, (i16 & 2) != 0 ? new ArrayList() : collection, (i16 & 4) != 0 ? 3 : i3, (i16 & 8) != 0 ? null : bundle);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) {
            return;
        }
        iPatchRedirector.redirect((short) 9, this, Long.valueOf(j3), collection, Integer.valueOf(i3), bundle, Integer.valueOf(i16), defaultConstructorMarker);
    }

    @Override // java.util.LinkedList
    @NotNull
    public MsgListState clone() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (MsgListState) iPatchRedirector.redirect((short) 1, (Object) this);
        }
        Object clone = super.clone();
        Intrinsics.checkNotNullExpressionValue(clone, "super.clone()");
        long j3 = this.focusIndex;
        if (clone != null) {
            return new MsgListState(j3, (Collection) clone, this.updateType, this.extra);
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Collection<com.tencent.aio.data.msglist.IMsgItem>");
    }

    @Override // java.util.LinkedList, java.util.AbstractCollection, java.util.Collection, java.util.List, java.util.Deque
    public final /* bridge */ boolean contains(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this, obj)).booleanValue();
        }
        if (obj instanceof a) {
            return contains((a) obj);
        }
        return false;
    }

    @Override // java.util.LinkedList, java.util.AbstractList, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Integer) iPatchRedirector.redirect((short) 19, (Object) this, obj)).intValue();
        }
        if (obj instanceof a) {
            return indexOf((a) obj);
        }
        return -1;
    }

    @Override // java.util.LinkedList, java.util.AbstractList, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Integer) iPatchRedirector.redirect((short) 21, (Object) this, obj)).intValue();
        }
        if (obj instanceof a) {
            return lastIndexOf((a) obj);
        }
        return -1;
    }

    public /* bridge */ boolean remove(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 12)) ? super.remove((Object) aVar) : ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this, (Object) aVar)).booleanValue();
    }

    @Override // java.util.LinkedList, java.util.AbstractCollection, java.util.Collection, java.util.List, java.util.Deque
    public final /* bridge */ boolean remove(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this, obj)).booleanValue();
        }
        if (obj instanceof a) {
            return remove((a) obj);
        }
        return false;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MsgListState(long j3, @NotNull Collection<? extends a> list, int i3, @Nullable Bundle bundle) {
        super(list);
        Intrinsics.checkNotNullParameter(list, "list");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Long.valueOf(j3), list, Integer.valueOf(i3), bundle);
            return;
        }
        this.focusIndex = j3;
        this.updateType = i3;
        this.extra = bundle;
    }

    @Deprecated(message = "\u5e9f\u5f03\uff0c\u643a\u5e26\u53c2\u6570\uff0c\u8bf7\u52a0\u5165 extra!!")
    public static /* synthetic */ void getFocusIndex$annotations() {
    }
}
