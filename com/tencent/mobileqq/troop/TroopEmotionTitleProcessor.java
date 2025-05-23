package com.tencent.mobileqq.troop;

import android.text.SpannableString;
import android.util.LruCache;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.IChatSettingForTroopApi;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.classadapter.SingleLineTextView;
import java.lang.ref.WeakReference;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\r\n\u0002\b\u0006\u0018\u0000 \u000f2\u00020\u0001:\u0001\u0007B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R \u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u000b\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/troop/TroopEmotionTitleProcessor;", "Lcom/tencent/qqnt/chats/inject/title/a;", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tencent/qqnt/classadapter/SingleLineTextView;", "view", "", "a", "Landroid/util/LruCache;", "", "", "Landroid/util/LruCache;", "lruCache", "<init>", "()V", "b", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class TroopEmotionTitleProcessor extends com.tencent.qqnt.chats.inject.title.a {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: c, reason: collision with root package name */
    private static final Lazy<Boolean> f293497c;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final LruCache<Integer, CharSequence> lruCache = new LruCache<>(20);

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/troop/TroopEmotionTitleProcessor$a;", "", "", "enableEmotionReplay$delegate", "Lkotlin/Lazy;", "a", "()Z", "enableEmotionReplay", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.TroopEmotionTitleProcessor$a, reason: from kotlin metadata */
    /* loaded from: classes35.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a() {
            return ((Boolean) TroopEmotionTitleProcessor.f293497c.getValue()).booleanValue();
        }

        Companion() {
        }
    }

    static {
        Lazy<Boolean> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<Boolean>() { // from class: com.tencent.mobileqq.troop.TroopEmotionTitleProcessor$Companion$enableEmotionReplay$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return Boolean.valueOf(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("troop_908_118422673", true));
            }
        });
        f293497c = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(final com.tencent.qqnt.chats.core.adapter.itemdata.g item, final TroopEmotionTitleProcessor this$0, final int i3, final WeakReference ref) {
        Intrinsics.checkNotNullParameter(item, "$item");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(ref, "$ref");
        final SpannableString spannableStringFromColorNickText = ((IChatSettingForTroopApi) QRoute.api(IChatSettingForTroopApi.class)).getSpannableStringFromColorNickText(item.w().e(), 16);
        if (spannableStringFromColorNickText == null) {
            if (QLog.isDebugVersion()) {
                QLog.d("TroopEmotionTitleProcessor", 1, "[updateTitle] get no enable nick, return");
                return;
            }
            return;
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.troop.i
            @Override // java.lang.Runnable
            public final void run() {
                TroopEmotionTitleProcessor.f(TroopEmotionTitleProcessor.this, i3, spannableStringFromColorNickText, ref, item);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(TroopEmotionTitleProcessor this$0, int i3, SpannableString name, WeakReference ref, com.tencent.qqnt.chats.core.adapter.itemdata.g item) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(ref, "$ref");
        Intrinsics.checkNotNullParameter(item, "$item");
        this$0.lruCache.put(Integer.valueOf(i3), name);
        SingleLineTextView singleLineTextView = (SingleLineTextView) ref.get();
        if (singleLineTextView != null && Intrinsics.areEqual(singleLineTextView.getTag(R.id.f181427), Long.valueOf(item.m()))) {
            if (QLog.isDebugVersion()) {
                QLog.d("TroopEmotionTitleProcessor", 1, "[updateTitle] set new data");
            }
            Intrinsics.checkNotNullExpressionValue(name, "name");
            if (name.length() > 0) {
                singleLineTextView.setText(name);
            }
        }
    }

    @Override // com.tencent.qqnt.chats.inject.title.a
    public void a(final com.tencent.qqnt.chats.core.adapter.itemdata.g item, SingleLineTextView view) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(view, "view");
        view.setTag(R.id.f181427, Long.valueOf(item.m()));
        if (item.n() != 2) {
            return;
        }
        if (!INSTANCE.a()) {
            if (QLog.isDebugVersion()) {
                QLog.d("TroopEmotionTitleProcessor", 1, "[updateTitle] switch is close");
                return;
            }
            return;
        }
        final int hashCode = item.w().e().hashCode();
        CharSequence charSequence = this.lruCache.get(Integer.valueOf(hashCode));
        if (charSequence != null) {
            if (QLog.isDebugVersion()) {
                QLog.d("TroopEmotionTitleProcessor", 1, "[updateTitle] reset last data");
            }
            if (charSequence.length() > 0) {
                view.setText(charSequence);
                return;
            }
            return;
        }
        String str = item.s().peerName;
        Intrinsics.checkNotNullExpressionValue(str, "item.originData.peerName");
        if (str.length() == 0) {
            String str2 = item.s().remark;
            Intrinsics.checkNotNullExpressionValue(str2, "item.originData.remark");
            if (str2.length() == 0) {
                if (QLog.isDebugVersion()) {
                    QLog.d("TroopEmotionTitleProcessor", 1, "[updateTitle] fail when name empty");
                    return;
                }
                return;
            }
        }
        final WeakReference weakReference = new WeakReference(view);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.troop.h
            @Override // java.lang.Runnable
            public final void run() {
                TroopEmotionTitleProcessor.e(com.tencent.qqnt.chats.core.adapter.itemdata.g.this, this, hashCode, weakReference);
            }
        }, 16, null, true);
    }
}
