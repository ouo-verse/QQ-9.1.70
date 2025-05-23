package com.tencent.qqnt.aio.api.impl;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.google.gson.Gson;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qmmkv.v2.MMKVOptionEntityV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.SecUtil;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.aio.api.IAIOEmoReplyMenuApi;
import com.tencent.qqnt.aio.menu.MenuUtils;
import com.tencent.qqnt.aio.utils.ViewUtils;
import com.tencent.qqnt.freesia_wrapper.FreesiaWrapperImpl;
import com.tencent.qqnt.http.api.IHttpService;
import com.tencent.qqnt.http.api.b;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u0000 '2\u00020\u0001:\u0001(B\u0007\u00a2\u0006\u0004\b%\u0010&J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J*\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J*\u0010\u0010\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0002J\u0016\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0013H\u0002J\b\u0010\u0016\u001a\u00020\u0006H\u0002J\u0012\u0010\u0018\u001a\u00020\u00112\b\u0010\u0017\u001a\u0004\u0018\u00010\u0014H\u0002J,\u0010\u001a\u001a\u0004\u0018\u00010\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00192\u0006\u0010\u000b\u001a\u00020\nH\u0016J,\u0010\u001b\u001a\u0004\u0018\u00010\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u001a\u0010\u001c\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u000e\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dH\u0016R\u0016\u0010 \u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010\"\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010!R\u001c\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$\u00a8\u0006)"}, d2 = {"Lcom/tencent/qqnt/aio/api/impl/AIOEmoReplyMenuApiImpl;", "Lcom/tencent/qqnt/aio/api/IAIOEmoReplyMenuApi;", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "", "hasEmotionMenuItem", "Landroid/view/View;", "anchorView", "Lcom/tencent/qqnt/aio/menu/w;", "onMenuActionListener", "Landroid/view/ViewGroup;", "createSeparateEmoMenuView", "Lcom/tencent/qqnt/aio/menu/ui/a;", ParseCommon.CONTAINER, "createDefaultEmoMenuView", "", "checkEmoReplyAtmosphereFile", "Lkotlin/Pair;", "Lcom/tencent/qqnt/aio/api/impl/t;", "checkConfig", "isAtmosphereDefaultFileCorrect", "info", "downloadFile", "", "getDefaultEmoReplyMenuView", "getSeparateEmoReplyMenuView", "hasEmoReplyMenu", "", "", "getTopBgEmojiIdList", "isFileDownloading", "Z", "isConfigChecked", "topBgEmojiIdList", "Ljava/util/List;", "<init>", "()V", "Companion", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class AIOEmoReplyMenuApiImpl implements IAIOEmoReplyMenuApi {
    static IPatchRedirector $redirector_ = null;

    @NotNull
    private static final String ATMOSPHERE_DEFAULT;

    @NotNull
    private static final String ATMOSPHERE_DIR;

    @NotNull
    private static final String ATMOSPHERE_DIR_NAME = "atmosphere";

    @NotNull
    private static final String ATMOSPHERE_ZIP;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final String DEFAULT_DOWNLOAD_URL = "https://static-res.qq.com/static-res/aio/emoticon/emo_reply_atmosphere.zip";
    private static final int EMO_LINE_MARGIN_END;
    private static final int EMO_LINE_MARGIN_START;

    @NotNull
    private static final String KEY_ATMOSPHERE_TIME = "EmoReplyAtmosphereTime";

    @NotNull
    public static final String TAG = "AIOEmoReplyMenu";
    private volatile boolean isConfigChecked;
    private volatile boolean isFileDownloading;

    @NotNull
    private List<String> topBgEmojiIdList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\n\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0004R\u0014\u0010\u0011\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0004\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/qqnt/aio/api/impl/AIOEmoReplyMenuApiImpl$a;", "", "", "ATMOSPHERE_DIR", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "ATMOSPHERE_DEFAULT", "a", "ATMOSPHERE_DIR_NAME", "ATMOSPHERE_ZIP", "DEFAULT_DOWNLOAD_URL", "", "EMO_LINE_MARGIN_END", "I", "EMO_LINE_MARGIN_START", "KEY_ATMOSPHERE_TIME", "TAG", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.api.impl.AIOEmoReplyMenuApiImpl$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) defaultConstructorMarker);
        }

        @NotNull
        public final String a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return AIOEmoReplyMenuApiImpl.ATMOSPHERE_DEFAULT;
            }
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }

        @NotNull
        public final String b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return AIOEmoReplyMenuApiImpl.ATMOSPHERE_DIR;
            }
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(65437);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
            return;
        }
        INSTANCE = new Companion(null);
        String sDKPrivatePath = VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH_EMOJIS + ATMOSPHERE_DIR_NAME + File.separator);
        Intrinsics.checkNotNullExpressionValue(sDKPrivatePath, "getSDKPrivatePath(AppCon\u2026IR_NAME + File.separator)");
        ATMOSPHERE_DIR = sDKPrivatePath;
        ATMOSPHERE_DEFAULT = sDKPrivatePath + "default.json";
        ATMOSPHERE_ZIP = sDKPrivatePath + "emo_reply_atmosphere.zip";
        EMO_LINE_MARGIN_START = com.tencent.qqnt.aio.utils.l.b(6);
        EMO_LINE_MARGIN_END = com.tencent.qqnt.aio.utils.l.b(2);
    }

    public AIOEmoReplyMenuApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.topBgEmojiIdList = new ArrayList();
        }
    }

    private final Pair<Boolean, t> checkConfig() {
        t tVar;
        try {
            tVar = (t) new Gson().fromJson(FreesiaWrapperImpl.INSTANCE.b().loadConfigAsString("aio_menu_emoji_reply_bg", ""), t.class);
        } catch (Exception unused) {
            tVar = null;
        }
        boolean z16 = false;
        if (tVar != null && tVar.e()) {
            z16 = true;
        }
        if (z16) {
            MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(MobileQQ.sMobileQQ, "common_mmkv_configurations");
            Intrinsics.checkNotNullExpressionValue(fromV2, "fromV2(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
            String string = fromV2.getString(KEY_ATMOSPHERE_TIME, null);
            this.topBgEmojiIdList = tVar.c();
            return new Pair<>(Boolean.valueOf(!Intrinsics.areEqual(string, tVar.b())), tVar);
        }
        return new Pair<>(Boolean.FALSE, null);
    }

    private final void checkEmoReplyAtmosphereFile() {
        if (this.isConfigChecked) {
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.aio.api.impl.k
            @Override // java.lang.Runnable
            public final void run() {
                AIOEmoReplyMenuApiImpl.checkEmoReplyAtmosphereFile$lambda$15(AIOEmoReplyMenuApiImpl.this);
            }
        }, 192, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkEmoReplyAtmosphereFile$lambda$15(AIOEmoReplyMenuApiImpl this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Pair<Boolean, t> checkConfig = this$0.checkConfig();
        boolean isAtmosphereDefaultFileCorrect = this$0.isAtmosphereDefaultFileCorrect();
        QLog.i(TAG, 1, "checkEmoReplyAtmosphereFile  needUpdateAndInfo:" + checkConfig + ", fileCorrect:" + isAtmosphereDefaultFileCorrect);
        if (!checkConfig.getFirst().booleanValue() && isAtmosphereDefaultFileCorrect) {
            this$0.isConfigChecked = true;
            return;
        }
        if (this$0.isFileDownloading) {
            QLog.i(TAG, 1, "checkEmoReplyAtmosphereFile  isFileDownloading:" + this$0.isFileDownloading);
            return;
        }
        try {
            FileUtils.deleteFile(new File(ATMOSPHERE_DIR));
            this$0.downloadFile(checkConfig.getSecond());
        } finally {
            this$0.isFileDownloading = false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final ViewGroup createDefaultEmoMenuView(Context context, AIOMsgItem msgItem, final com.tencent.qqnt.aio.menu.ui.a container, final com.tencent.qqnt.aio.menu.w onMenuActionListener) {
        Unit unit;
        boolean z16;
        int i3;
        final View.OnClickListener onClickListener;
        List<View> m3 = new EmotionMenusCreator(context, msgItem).m();
        if (m3 != null) {
            n.m("EmotionMenusCreator return " + m3.size());
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            n.m("EmotionMenusCreator return null");
        }
        List<View> list = m3;
        if (list != null && !list.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return null;
        }
        Intrinsics.checkNotNull(container, "null cannot be cast to non-null type android.view.ViewGroup");
        n.m("container width = " + ((ViewGroup) container).getMeasuredWidth());
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        ViewUtils viewUtils = ViewUtils.f352270a;
        linearLayout.setPadding(viewUtils.a(1.0f), 0, viewUtils.a(1.0f), 0);
        for (View view : m3) {
            linearLayout.addView(view);
            i3 = n.f348959f;
            Object tag = view.getTag(i3);
            if (tag instanceof View.OnClickListener) {
                onClickListener = (View.OnClickListener) tag;
            } else {
                onClickListener = null;
            }
            if (onClickListener != null) {
                view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.aio.api.impl.h
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        AIOEmoReplyMenuApiImpl.createDefaultEmoMenuView$lambda$13$lambda$12$lambda$11(onClickListener, container, onMenuActionListener, view2);
                    }
                });
            }
        }
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.aio.api.impl.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AIOEmoReplyMenuApiImpl.createDefaultEmoMenuView$lambda$14(com.tencent.qqnt.aio.menu.ui.a.this, onMenuActionListener, view2);
            }
        });
        return linearLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createDefaultEmoMenuView$lambda$13$lambda$12$lambda$11(View.OnClickListener listener, com.tencent.qqnt.aio.menu.ui.a container, com.tencent.qqnt.aio.menu.w onMenuActionListener, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(listener, "$listener");
        Intrinsics.checkNotNullParameter(container, "$container");
        Intrinsics.checkNotNullParameter(onMenuActionListener, "$onMenuActionListener");
        listener.onClick(view);
        container.dismiss();
        onMenuActionListener.a(false);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createDefaultEmoMenuView$lambda$14(com.tencent.qqnt.aio.menu.ui.a container, com.tencent.qqnt.aio.menu.w onMenuActionListener, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(container, "$container");
        Intrinsics.checkNotNullParameter(onMenuActionListener, "$onMenuActionListener");
        container.dismiss();
        onMenuActionListener.a(false);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final ViewGroup createSeparateEmoMenuView(Context context, AIOMsgItem msgItem, View anchorView, final com.tencent.qqnt.aio.menu.w onMenuActionListener) {
        Unit unit;
        boolean z16;
        int i3;
        final ae aeVar;
        List<View> p16 = new EmotionMenusCreator(context, msgItem).p(anchorView);
        if (p16 != null) {
            n.m("EmotionMenusCreator return " + p16.size());
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            n.m("EmotionMenusCreator return null");
        }
        List<View> list = p16;
        if (list != null && !list.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return null;
        }
        n.m("createSeparateEmoMenuView msgId:" + msgItem.getMsgId());
        checkEmoReplyAtmosphereFile();
        final LinearLayout linearLayout = new LinearLayout(context);
        float k3 = MenuUtils.f351230a.k(context);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        linearLayout.setPadding((int) (EMO_LINE_MARGIN_START * k3), 0, (int) (EMO_LINE_MARGIN_END * k3), 0);
        for (final View view : p16) {
            linearLayout.addView(view);
            i3 = n.f348959f;
            Object tag = view.getTag(i3);
            if (tag instanceof ae) {
                aeVar = (ae) tag;
            } else {
                aeVar = null;
            }
            if (aeVar != null) {
                view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.aio.api.impl.l
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        AIOEmoReplyMenuApiImpl.createSeparateEmoMenuView$lambda$6$lambda$5$lambda$4(ae.this, linearLayout, onMenuActionListener, view, view2);
                    }
                });
            }
        }
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.aio.api.impl.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AIOEmoReplyMenuApiImpl.createSeparateEmoMenuView$lambda$7(com.tencent.qqnt.aio.menu.w.this, view2);
            }
        });
        return linearLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createSeparateEmoMenuView$lambda$6$lambda$5$lambda$4(ae listener, LinearLayout qqFaceLinearLayout, final com.tencent.qqnt.aio.menu.w onMenuActionListener, View emotionMenuItem, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(listener, "$listener");
        Intrinsics.checkNotNullParameter(qqFaceLinearLayout, "$qqFaceLinearLayout");
        Intrinsics.checkNotNullParameter(onMenuActionListener, "$onMenuActionListener");
        Intrinsics.checkNotNullParameter(emotionMenuItem, "$emotionMenuItem");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        if (listener.a(qqFaceLinearLayout, it)) {
            onMenuActionListener.a(true);
        } else {
            emotionMenuItem.postDelayed(new Runnable() { // from class: com.tencent.qqnt.aio.api.impl.j
                @Override // java.lang.Runnable
                public final void run() {
                    AIOEmoReplyMenuApiImpl.createSeparateEmoMenuView$lambda$6$lambda$5$lambda$4$lambda$3(com.tencent.qqnt.aio.menu.w.this);
                }
            }, 200L);
        }
        EventCollector.getInstance().onViewClicked(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createSeparateEmoMenuView$lambda$6$lambda$5$lambda$4$lambda$3(com.tencent.qqnt.aio.menu.w onMenuActionListener) {
        Intrinsics.checkNotNullParameter(onMenuActionListener, "$onMenuActionListener");
        onMenuActionListener.a(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createSeparateEmoMenuView$lambda$7(com.tencent.qqnt.aio.menu.w onMenuActionListener, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(onMenuActionListener, "$onMenuActionListener");
        onMenuActionListener.a(true);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void downloadFile(t info) {
        String str;
        String str2;
        boolean equals;
        Bundle bundle = new Bundle();
        String str3 = ATMOSPHERE_ZIP;
        File file = new File(str3);
        if (info == null || (str = info.d()) == null) {
            str = DEFAULT_DOWNLOAD_URL;
        }
        com.tencent.qqnt.http.api.m syncExecute = ((IHttpService) QRoute.api(IHttpService.class)).syncExecute(new b.a(TAG, str, new File(str3)).S(Bundle.class, bundle).c());
        QLog.i(TAG, 1, "result:" + syncExecute);
        if (!syncExecute.e()) {
            return;
        }
        this.isConfigChecked = true;
        if (!file.exists()) {
            QLog.i(TAG, 1, "file not exist, path:" + file.getAbsolutePath());
            return;
        }
        if (info != null) {
            String fileMd5 = SecUtil.getFileMd5(file);
            equals = StringsKt__StringsJVMKt.equals(info.a(), fileMd5, true);
            if (!equals) {
                QLog.i(TAG, 1, "file md5 not match, md5:" + fileMd5);
                return;
            }
        }
        try {
            com.tencent.qqnt.emotion.utils.t.a(file, ATMOSPHERE_DIR);
        } catch (IOException e16) {
            QLog.i(TAG, 1, "file unZipFile, e:" + e16);
        }
        boolean delete = file.delete();
        MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(fromV2, "fromV2(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        String str4 = null;
        if (info != null) {
            str2 = info.b();
        } else {
            str2 = null;
        }
        fromV2.putString(KEY_ATMOSPHERE_TIME, str2);
        if (info != null) {
            str4 = info.b();
        }
        QLog.i(TAG, 1, "download success, deleteSuccess:" + delete + ", time:" + str4);
    }

    private final boolean hasEmotionMenuItem(Context context, AIOMsgItem msgItem) {
        boolean z16;
        List<View> m3 = new EmotionMenusCreator(context, msgItem).m();
        if (m3 != null && !m3.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        return !z16;
    }

    private final boolean isAtmosphereDefaultFileCorrect() {
        return new File(ATMOSPHERE_DEFAULT).exists();
    }

    @Override // com.tencent.qqnt.aio.api.IAIOEmoReplyMenuApi
    @Nullable
    public ViewGroup getDefaultEmoReplyMenuView(@Nullable Context context, @NotNull AIOMsgItem msgItem, @NotNull Object container, @NotNull com.tencent.qqnt.aio.menu.w onMenuActionListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ViewGroup) iPatchRedirector.redirect((short) 2, this, context, msgItem, container, onMenuActionListener);
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(onMenuActionListener, "onMenuActionListener");
        if (context == null) {
            n.m("context is null");
            return null;
        }
        if (!com.tencent.mobileqq.aio.msglist.holder.component.msgtail.utils.a.h(msgItem)) {
            return null;
        }
        if (!com.tencent.mobileqq.aio.msglist.holder.component.msgtail.utils.a.g(msgItem)) {
            n.m("msgItem is not support emo reply");
            return null;
        }
        if (!(container instanceof com.tencent.qqnt.aio.menu.ui.a)) {
            return null;
        }
        return createDefaultEmoMenuView(context, msgItem, (com.tencent.qqnt.aio.menu.ui.a) container, onMenuActionListener);
    }

    @Override // com.tencent.qqnt.aio.api.IAIOEmoReplyMenuApi
    @Nullable
    public View getSeparateEmoReplyMenuView(@Nullable Context context, @NotNull AIOMsgItem msgItem, @NotNull View anchorView, @NotNull com.tencent.qqnt.aio.menu.w onMenuActionListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, this, context, msgItem, anchorView, onMenuActionListener);
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(anchorView, "anchorView");
        Intrinsics.checkNotNullParameter(onMenuActionListener, "onMenuActionListener");
        if (context == null) {
            n.m("[getSeparateEmoReplyMenuView] context is null");
            return null;
        }
        if (!com.tencent.mobileqq.aio.msglist.holder.component.msgtail.utils.a.h(msgItem)) {
            return null;
        }
        if (!com.tencent.mobileqq.aio.msglist.holder.component.msgtail.utils.a.g(msgItem)) {
            n.m("[getSeparateEmoReplyMenuView] msgItem is not support emo reply");
            return null;
        }
        return createSeparateEmoMenuView(context, msgItem, anchorView, onMenuActionListener);
    }

    @Override // com.tencent.qqnt.aio.api.IAIOEmoReplyMenuApi
    @NotNull
    public List<String> getTopBgEmojiIdList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (List) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.topBgEmojiIdList;
    }

    @Override // com.tencent.qqnt.aio.api.IAIOEmoReplyMenuApi
    public boolean hasEmoReplyMenu(@Nullable Context context, @NotNull AIOMsgItem msgItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) context, (Object) msgItem)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        if (context == null) {
            n.m("[hasEmoReplyMenu] context is null");
            return false;
        }
        if (!com.tencent.mobileqq.aio.msglist.holder.component.msgtail.utils.a.h(msgItem)) {
            return false;
        }
        if (!com.tencent.mobileqq.aio.msglist.holder.component.msgtail.utils.a.g(msgItem)) {
            n.m("[hasEmoReplyMenu] msgItem is not support emo reply");
            return false;
        }
        return hasEmotionMenuItem(context, msgItem);
    }
}
