package com.tencent.mobileqq.emoticon.data.provider;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emosm.api.IEmotionSearchManagerService;
import com.tencent.mobileqq.emosm.emosearch.EmotionSearchItem;
import com.tencent.mobileqq.emoticon.api.EmojiManagerServiceConstant;
import com.tencent.mobileqq.emoticon.data.EmoticonDataSource;
import com.tencent.mobileqq.emoticon.data.HotPicEmoticonInfo;
import com.tencent.mobileqq.emoticon.data.ipc.d;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 #2\u00020\u00012\u00020\u0002:\u0001$B\u0007\u00a2\u0006\u0004\b!\u0010\"J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003J\b\u0010\b\u001a\u00020\u0007H\u0016J\u0012\u0010\u000b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010\u000e\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u000e\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fR\u0018\u0010\n\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0004\u001a\u00020\u00038\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0018\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR$\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\u00110\u001cj\b\u0012\u0004\u0012\u00020\u0011`\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/emoticon/data/provider/c;", "Lcom/tencent/mobileqq/emoticon/data/EmoticonDataSource;", "Lcom/tencent/mobileqq/emosm/api/IEmotionSearchManagerService$a;", "Lmqq/app/AppRuntime;", "appRuntime", "", "c", "", Const.BUNDLE_KEY_REQUEST, "Lcom/tencent/mobileqq/emoticon/data/EmoticonDataSource$DataSourceListener;", "listener", "setListener", "Lcom/tencent/mobileqq/emosm/api/IEmotionSearchManagerService$EmotionSearchResult;", "result", "onSearchCallBack", "Lcom/tencent/mobileqq/emosm/emosearch/EmotionSearchItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tencent/mobileqq/emoticonview/EmoticonInfo;", "d", "Lcom/tencent/mobileqq/emoticon/data/EmoticonDataSource$DataSourceListener;", "e", "Lmqq/app/AppRuntime;", "f", "Z", "firstRequest", h.F, "Lcom/tencent/mobileqq/emosm/api/IEmotionSearchManagerService$EmotionSearchResult;", "searchResult", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "i", "Ljava/util/ArrayList;", EmojiManagerServiceConstant.PARAMS_EMOTICON_LIST, "<init>", "()V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "qqemoticondata-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class c implements EmoticonDataSource, IEmotionSearchManagerService.a {
    static IPatchRedirector $redirector_;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private EmoticonDataSource.DataSourceListener listener;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private AppRuntime appRuntime;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean firstRequest;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private IEmotionSearchManagerService.EmotionSearchResult searchResult;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<EmoticonInfo> emoticonList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/emoticon/data/provider/c$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqemoticondata-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.emoticon.data.provider.c$a, reason: from kotlin metadata */
    /* loaded from: classes12.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(28151);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.firstRequest = true;
            this.emoticonList = new ArrayList<>();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(c this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        EmoticonDataSource.DataSourceListener dataSourceListener = this$0.listener;
        if (dataSourceListener != null) {
            dataSourceListener.onGetEmoticons(false, this$0.emoticonList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(c this$0, IEmotionSearchManagerService.EmotionSearchResult emotionSearchResult) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        EmoticonDataSource.DataSourceListener dataSourceListener = this$0.listener;
        if (dataSourceListener != null) {
            dataSourceListener.onGetEmoticons(emotionSearchResult.isHasMore(), this$0.emoticonList);
        }
    }

    public final boolean c(@NotNull AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
        this.appRuntime = appRuntime;
        d.INSTANCE.a().n(appRuntime, this);
        return true;
    }

    @NotNull
    public final EmoticonInfo d(@NotNull EmotionSearchItem item) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (EmoticonInfo) iPatchRedirector.redirect((short) 6, (Object) this, (Object) item);
        }
        Intrinsics.checkNotNullParameter(item, "item");
        return new HotPicEmoticonInfo(item);
    }

    @Override // com.tencent.mobileqq.emosm.api.IEmotionSearchManagerService.a
    public void onSearchCallBack(@Nullable final IEmotionSearchManagerService.EmotionSearchResult result) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) result);
            return;
        }
        if (result == null) {
            QLog.i("HotPicDataSource", 1, "onSearchCallBack, result is null");
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.emoticon.data.provider.a
                @Override // java.lang.Runnable
                public final void run() {
                    c.e(c.this);
                }
            });
            return;
        }
        this.searchResult = result;
        int size = result.itemList.size();
        for (int size2 = this.emoticonList.size(); size2 < size; size2++) {
            ArrayList<EmoticonInfo> arrayList = this.emoticonList;
            EmotionSearchItem emotionSearchItem = result.itemList.get(size2);
            Intrinsics.checkNotNullExpressionValue(emotionSearchItem, "result.itemList[i]");
            arrayList.add(d(emotionSearchItem));
        }
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.emoticon.data.provider.b
            @Override // java.lang.Runnable
            public final void run() {
                c.f(c.this, result);
            }
        });
    }

    @Override // com.tencent.mobileqq.emoticon.data.EmoticonDataSource
    public void request() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        AppRuntime appRuntime = null;
        if (this.firstRequest) {
            this.firstRequest = false;
            d a16 = d.INSTANCE.a();
            AppRuntime appRuntime2 = this.appRuntime;
            if (appRuntime2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("appRuntime");
            } else {
                appRuntime = appRuntime2;
            }
            a16.m(appRuntime);
            return;
        }
        d a17 = d.INSTANCE.a();
        AppRuntime appRuntime3 = this.appRuntime;
        if (appRuntime3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appRuntime");
        } else {
            appRuntime = appRuntime3;
        }
        a17.h(appRuntime);
    }

    @Override // com.tencent.mobileqq.emoticon.data.EmoticonDataSource
    public void setListener(@Nullable EmoticonDataSource.DataSourceListener listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) listener);
        } else {
            this.listener = listener;
        }
    }
}
