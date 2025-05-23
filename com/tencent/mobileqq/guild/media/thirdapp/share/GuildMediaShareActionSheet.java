package com.tencent.mobileqq.guild.media.thirdapp.share;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.data.GuildSharePageSource;
import com.tencent.mobileqq.guild.data.v;
import com.tencent.mobileqq.guild.media.core.j;
import com.tencent.mobileqq.guild.share.m;
import com.tencent.mobileqq.guild.share.w;
import com.tencent.mobileqq.guild.usecases.b;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.util.LoadingUtil;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.Job;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u0000 ?2\u00020\u0001:\u0006@ABCDEB+\b\u0016\u0012\u0006\u00104\u001a\u000203\u0012\u0006\u00106\u001a\u000205\u0012\b\u00108\u001a\u0004\u0018\u000107\u0012\u0006\u00109\u001a\u00020\u001d\u00a2\u0006\u0004\b:\u0010;B3\b\u0016\u0012\u0006\u00104\u001a\u000203\u0012\u0006\u00106\u001a\u000205\u0012\b\u00108\u001a\u0004\u0018\u000107\u0012\u0006\u00109\u001a\u00020\u001d\u0012\u0006\u0010=\u001a\u00020<\u00a2\u0006\u0004\b:\u0010>J\u0012\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J\u001b\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0006H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\f\u0010\rJ\b\u0010\u000e\u001a\u00020\u0004H\u0002J\b\u0010\u000f\u001a\u00020\u0004H\u0014J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0014J\b\u0010\u0011\u001a\u00020\u0004H\u0014J\b\u0010\u0012\u001a\u00020\u0004H\u0016J\u000e\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013J\u000e\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0016R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010#\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010&\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010(\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010'R\u0018\u0010,\u001a\u00060)R\u00020\u00008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0018\u00100\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00102\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u00101\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006F"}, d2 = {"Lcom/tencent/mobileqq/guild/media/thirdapp/share/GuildMediaShareActionSheet;", "Lcom/tencent/mobileqq/guild/share/m;", "", "forceUpdate", "", BdhLogUtil.LogTag.Tag_Req, "", "action", "T", "U", "shareType", "Lcom/tencent/mobileqq/guild/media/thirdapp/share/GuildMediaShareActionSheet$b;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "V", "g", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, BdhLogUtil.LogTag.Tag_Conn, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lcom/tencent/mobileqq/guild/media/thirdapp/share/GuildMediaShareActionSheet$e;", "extraInfo", "W", "Lcom/tencent/mobileqq/guild/media/thirdapp/share/GuildMediaShareActionSheet$d;", "callback", "X", "Landroid/app/Dialog;", "v", "Landroid/app/Dialog;", "shareDialog", "Lcom/tencent/mobileqq/guild/media/thirdapp/share/GuildMediaShareActionSheet$ShareScene;", "w", "Lcom/tencent/mobileqq/guild/media/thirdapp/share/GuildMediaShareActionSheet$ShareScene;", "shareScene", HippyTKDListViewAdapter.X, "Lcom/tencent/mobileqq/guild/media/thirdapp/share/GuildMediaShareActionSheet$d;", "shareCallback", "y", "I", "shareClickAction", "Lcom/tencent/mobileqq/guild/media/thirdapp/share/GuildMediaShareActionSheet$e;", "shareExtraInfo", "Lcom/tencent/mobileqq/guild/media/thirdapp/share/GuildMediaShareActionSheet$c;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/tencent/mobileqq/guild/media/thirdapp/share/GuildMediaShareActionSheet$c;", "shareCancelListener", "Lcom/tencent/mobileqq/qcoroutine/api/coroutine/b;", "B", "Lcom/tencent/mobileqq/qcoroutine/api/coroutine/b;", "requestShortJob", "Z", "isDismiss", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "guildInfo", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", "channelInfo", "scene", "<init>", "(Landroid/app/Activity;Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;Lcom/tencent/mobileqq/guild/media/thirdapp/share/GuildMediaShareActionSheet$ShareScene;)V", "", "shareSceneId", "(Landroid/app/Activity;Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;Lcom/tencent/mobileqq/guild/media/thirdapp/share/GuildMediaShareActionSheet$ShareScene;Ljava/lang/String;)V", "D", "a", "b", "c", "d", "e", "ShareScene", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildMediaShareActionSheet extends m {

    @NotNull
    private static final HashMap<Integer, Integer> E;

    /* renamed from: A, reason: from kotlin metadata */
    @NotNull
    private final c shareCancelListener;

    /* renamed from: B, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.qcoroutine.api.coroutine.b requestShortJob;

    /* renamed from: C, reason: from kotlin metadata */
    private boolean isDismiss;

    /* renamed from: v, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Dialog shareDialog;

    /* renamed from: w, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ShareScene shareScene;

    /* renamed from: x, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private d shareCallback;

    /* renamed from: y, reason: collision with root package name and from kotlin metadata */
    private int shareClickAction;

    /* renamed from: z, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private MediaShareExtraInfo shareExtraInfo;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/guild/media/thirdapp/share/GuildMediaShareActionSheet$ShareScene;", "", "scene", "", "(Ljava/lang/String;II)V", "getScene", "()I", "THIRD_APP_JSAPI", "MEDIA_TITLE_BAR", "FEED_RECOMMEND_CARD", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes14.dex */
    public enum ShareScene {
        THIRD_APP_JSAPI(1),
        MEDIA_TITLE_BAR(2),
        FEED_RECOMMEND_CARD(3);

        private final int scene;

        ShareScene(int i3) {
            this.scene = i3;
        }

        public final int getScene() {
            return this.scene;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\r\u00a2\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0019\u0010\u0011\u001a\u0004\u0018\u00010\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/guild/media/thirdapp/share/GuildMediaShareActionSheet$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "()I", "code", "Lcom/tencent/mobileqq/guild/usecases/b$c;", "b", "Lcom/tencent/mobileqq/guild/usecases/b$c;", "()Lcom/tencent/mobileqq/guild/usecases/b$c;", "fetchInfo", "<init>", "(ILcom/tencent/mobileqq/guild/usecases/b$c;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.media.thirdapp.share.GuildMediaShareActionSheet$b, reason: from toString */
    /* loaded from: classes14.dex */
    public static final /* data */ class FetchShortUrlRsp {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final int code;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final b.c fetchInfo;

        public FetchShortUrlRsp(int i3, @Nullable b.c cVar) {
            this.code = i3;
            this.fetchInfo = cVar;
        }

        /* renamed from: a, reason: from getter */
        public final int getCode() {
            return this.code;
        }

        @Nullable
        /* renamed from: b, reason: from getter */
        public final b.c getFetchInfo() {
            return this.fetchInfo;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof FetchShortUrlRsp)) {
                return false;
            }
            FetchShortUrlRsp fetchShortUrlRsp = (FetchShortUrlRsp) other;
            if (this.code == fetchShortUrlRsp.code && Intrinsics.areEqual(this.fetchInfo, fetchShortUrlRsp.fetchInfo)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode;
            int i3 = this.code * 31;
            b.c cVar = this.fetchInfo;
            if (cVar == null) {
                hashCode = 0;
            } else {
                hashCode = cVar.hashCode();
            }
            return i3 + hashCode;
        }

        @NotNull
        public String toString() {
            return "FetchShortUrlRsp(code=" + this.code + ", fetchInfo=" + this.fetchInfo + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/guild/media/thirdapp/share/GuildMediaShareActionSheet$c;", "Landroid/content/DialogInterface$OnCancelListener;", "Landroid/content/DialogInterface;", "dialog", "", "onCancel", "<init>", "(Lcom/tencent/mobileqq/guild/media/thirdapp/share/GuildMediaShareActionSheet;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    private final class c implements DialogInterface.OnCancelListener {
        public c() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(@NotNull DialogInterface dialog) {
            Intrinsics.checkNotNullParameter(dialog, "dialog");
            Logger.f235387a.d().d("GuildMediaShareActionSheet", 1, "[onCancel] ");
            GuildMediaShareActionSheet.this.shareClickAction = 0;
            GuildMediaShareActionSheet.this.g();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u0002H&\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/guild/media/thirdapp/share/GuildMediaShareActionSheet$d;", "", "", "code", "shareType", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public interface d {
        void a(int code, int shareType);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\r\u0010\u000bR\u0017\u0010\u0010\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u000f\u0010\u000bR\u0017\u0010\u0013\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u0012\u0010\u000b\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/guild/media/thirdapp/share/GuildMediaShareActionSheet$e;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "customTitle", "b", "fileId", "c", "sessionId", "d", "getPreviewImageUrl", "previewImageUrl", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.media.thirdapp.share.GuildMediaShareActionSheet$e, reason: from toString */
    /* loaded from: classes14.dex */
    public static final /* data */ class MediaShareExtraInfo {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String customTitle;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String fileId;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String sessionId;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String previewImageUrl;

        public MediaShareExtraInfo() {
            this(null, null, null, null, 15, null);
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getCustomTitle() {
            return this.customTitle;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final String getFileId() {
            return this.fileId;
        }

        @NotNull
        /* renamed from: c, reason: from getter */
        public final String getSessionId() {
            return this.sessionId;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MediaShareExtraInfo)) {
                return false;
            }
            MediaShareExtraInfo mediaShareExtraInfo = (MediaShareExtraInfo) other;
            if (Intrinsics.areEqual(this.customTitle, mediaShareExtraInfo.customTitle) && Intrinsics.areEqual(this.fileId, mediaShareExtraInfo.fileId) && Intrinsics.areEqual(this.sessionId, mediaShareExtraInfo.sessionId) && Intrinsics.areEqual(this.previewImageUrl, mediaShareExtraInfo.previewImageUrl)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((((this.customTitle.hashCode() * 31) + this.fileId.hashCode()) * 31) + this.sessionId.hashCode()) * 31) + this.previewImageUrl.hashCode();
        }

        @NotNull
        public String toString() {
            return "MediaShareExtraInfo(customTitle=" + this.customTitle + ", fileId=" + this.fileId + ", sessionId=" + this.sessionId + ", previewImageUrl=" + this.previewImageUrl + ")";
        }

        public MediaShareExtraInfo(@NotNull String customTitle, @NotNull String fileId, @NotNull String sessionId, @NotNull String previewImageUrl) {
            Intrinsics.checkNotNullParameter(customTitle, "customTitle");
            Intrinsics.checkNotNullParameter(fileId, "fileId");
            Intrinsics.checkNotNullParameter(sessionId, "sessionId");
            Intrinsics.checkNotNullParameter(previewImageUrl, "previewImageUrl");
            this.customTitle = customTitle;
            this.fileId = fileId;
            this.sessionId = sessionId;
            this.previewImageUrl = previewImageUrl;
        }

        public /* synthetic */ MediaShareExtraInfo(String str, String str2, String str3, String str4, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? "" : str2, (i3 & 4) != 0 ? "" : str3, (i3 & 8) != 0 ? "" : str4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lri1/a;", "error", "Lcom/tencent/mobileqq/guild/usecases/b$c;", "info", "", "a", "(Lri1/a;Lcom/tencent/mobileqq/guild/usecases/b$c;)V"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class f implements b.InterfaceC7909b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CancellableContinuation<FetchShortUrlRsp> f229555a;

        /* JADX WARN: Multi-variable type inference failed */
        f(CancellableContinuation<? super FetchShortUrlRsp> cancellableContinuation) {
            this.f229555a = cancellableContinuation;
        }

        @Override // com.tencent.mobileqq.guild.usecases.b.InterfaceC7909b
        public final void a(@NotNull ri1.a error, @Nullable b.c cVar) {
            String str;
            Intrinsics.checkNotNullParameter(error, "error");
            Logger.a d16 = Logger.f235387a.d();
            int i3 = error.f431477a;
            if (cVar != null) {
                str = cVar.f235319a;
            } else {
                str = null;
            }
            d16.d("GuildMediaShareActionSheet", 1, "[requestWithCustomUrlParam] code: " + i3 + " url: " + str);
            CancellableContinuation<FetchShortUrlRsp> cancellableContinuation = this.f229555a;
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuation.resumeWith(Result.m476constructorimpl(new FetchShortUrlRsp(error.f431477a, cVar)));
        }
    }

    static {
        HashMap<Integer, Integer> hashMapOf;
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to(3, 5), TuplesKt.to(9, 3), TuplesKt.to(10, 4), TuplesKt.to(1, 6), TuplesKt.to(197, 6));
        E = hashMapOf;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildMediaShareActionSheet(@NotNull Activity activity, @NotNull IGProGuildInfo guildInfo, @Nullable IGProChannelInfo iGProChannelInfo, @NotNull ShareScene scene) {
        super(activity, guildInfo, iGProChannelInfo, GuildSharePageSource.AUDIO_TOP_INVITE);
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(guildInfo, "guildInfo");
        Intrinsics.checkNotNullParameter(scene, "scene");
        this.shareCancelListener = new c();
        this.shareScene = scene;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object Q(int i3, Continuation<? super FetchShortUrlRsp> continuation) {
        Continuation intercepted;
        HashMap hashMapOf;
        String str;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("shareType", String.valueOf(i3)));
        MediaShareExtraInfo mediaShareExtraInfo = this.shareExtraInfo;
        if (mediaShareExtraInfo == null || (str = mediaShareExtraInfo.getSessionId()) == null) {
            str = "";
        }
        if (!TextUtils.isEmpty(str)) {
            hashMapOf.put("sessionId", str);
        }
        com.tencent.mobileqq.guild.usecases.b.h(this.f235048c, this.f235054i, this.f235065t, hashMapOf, new f(cancellableContinuationImpl));
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void R(boolean forceUpdate) {
        String str;
        Activity activity;
        String fileId;
        if (this.f235062q != null && !forceUpdate) {
            return;
        }
        IGProGuildInfo mGuildInfo = this.f235048c;
        Intrinsics.checkNotNullExpressionValue(mGuildInfo, "mGuildInfo");
        IGProChannelInfo mChannelInfo = this.f235054i;
        Intrinsics.checkNotNullExpressionValue(mChannelInfo, "mChannelInfo");
        b.c mShareUrlInfo = this.f235059n;
        Intrinsics.checkNotNullExpressionValue(mShareUrlInfo, "mShareUrlInfo");
        h hVar = new h(mGuildInfo, mChannelInfo, mShareUrlInfo);
        int i3 = this.f235065t;
        if (i3 != 0) {
            hVar.E(i3);
        }
        MediaShareExtraInfo mediaShareExtraInfo = this.shareExtraInfo;
        String str2 = "";
        if (mediaShareExtraInfo == null || (str = mediaShareExtraInfo.getCustomTitle()) == null) {
            str = "";
        }
        MediaShareExtraInfo mediaShareExtraInfo2 = this.shareExtraInfo;
        if (mediaShareExtraInfo2 != null && (fileId = mediaShareExtraInfo2.getFileId()) != null) {
            str2 = fileId;
        }
        hVar.H(str, str2);
        WeakReference<Activity> weakReference = this.f235047b;
        if (weakReference != null && (activity = weakReference.get()) != null) {
            w wVar = new w(activity, hVar, this.f235064s);
            this.f235062q = wVar;
            Bundle bundle = this.f235063r;
            if (bundle == null) {
                this.f235063r = wVar.g().getExtras();
                return;
            } else {
                bundle.putAll(wVar.g().getExtras());
                return;
            }
        }
        Logger logger = Logger.f235387a;
        Logger.b bVar = new Logger.b();
        bVar.a().add("[forceUpdateShareExecutor] activity is null, so return!");
        Iterator<T> it = bVar.a().iterator();
        while (it.hasNext()) {
            Logger.f235387a.d().e("GuildMediaShareActionSheet", 1, (String) it.next(), null);
        }
    }

    static /* synthetic */ void S(GuildMediaShareActionSheet guildMediaShareActionSheet, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        guildMediaShareActionSheet.R(z16);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x002c, code lost:
    
        if (r5 != 73) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final int T(int action) {
        Integer valueOf;
        Integer valueOf2 = Integer.valueOf(action);
        HashMap<Integer, Integer> hashMap = E;
        int i3 = 0;
        if (hashMap.containsKey(valueOf2)) {
            valueOf = hashMap.get(Integer.valueOf(action));
            if (valueOf == null) {
                valueOf = 0;
            }
        } else {
            if (action != 2) {
                if (action != 171) {
                    if (action != 72) {
                    }
                } else {
                    i3 = 2;
                }
                valueOf = Integer.valueOf(i3);
            }
            i3 = 1;
            valueOf = Integer.valueOf(i3);
        }
        return valueOf.intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean U() {
        Activity activity = this.f235047b.get();
        if (activity == null || activity.isDestroyed() || activity.isFinishing()) {
            return true;
        }
        return false;
    }

    private final void V() {
        int i3;
        HashMap hashMapOf;
        if (this.shareClickAction != 0) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        String r16 = j.c().r();
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("sgrp_channel_id", r16), TuplesKt.to("sgrp_sub_channel_id", j.c().e()), TuplesKt.to("sgrp_user_type", Integer.valueOf(v.c(r16))), TuplesKt.to("sgrp_scene_entry", Integer.valueOf(this.shareScene.getScene())), TuplesKt.to("sgrp_action_result", Integer.valueOf(i3)), TuplesKt.to("sgrp_share_item", Integer.valueOf(T(this.shareClickAction))));
        VideoReport.reportEvent("ev_sgrp_avchannel_app_share_panel", hashMapOf);
    }

    @Override // com.tencent.mobileqq.guild.share.m
    protected void C() {
        S(this, false, 1, null);
    }

    public final void W(@NotNull MediaShareExtraInfo extraInfo) {
        String str;
        boolean z16;
        String str2;
        boolean z17;
        String sessionId;
        String str3;
        String str4;
        Intrinsics.checkNotNullParameter(extraInfo, "extraInfo");
        this.shareExtraInfo = extraInfo;
        Bundle bundle = new Bundle();
        MediaShareExtraInfo mediaShareExtraInfo = this.shareExtraInfo;
        String str5 = null;
        if (mediaShareExtraInfo != null) {
            str = mediaShareExtraInfo.getCustomTitle();
        } else {
            str = null;
        }
        boolean z18 = false;
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        String str6 = "";
        if (!z16) {
            MediaShareExtraInfo mediaShareExtraInfo2 = this.shareExtraInfo;
            if (mediaShareExtraInfo2 == null || (str4 = mediaShareExtraInfo2.getCustomTitle()) == null) {
                str4 = "";
            }
            bundle.putString(AppConstants.Key.GUILD_MEDIA_ARK_CUSTOM_TITLE, str4);
        }
        MediaShareExtraInfo mediaShareExtraInfo3 = this.shareExtraInfo;
        if (mediaShareExtraInfo3 != null) {
            str2 = mediaShareExtraInfo3.getFileId();
        } else {
            str2 = null;
        }
        if (str2 != null && str2.length() != 0) {
            z17 = false;
        } else {
            z17 = true;
        }
        if (!z17) {
            MediaShareExtraInfo mediaShareExtraInfo4 = this.shareExtraInfo;
            if (mediaShareExtraInfo4 == null || (str3 = mediaShareExtraInfo4.getFileId()) == null) {
                str3 = "";
            }
            bundle.putString(AppConstants.Key.GUILD_MEDIA_ARK_CUSTOM_FILE_ID, str3);
        }
        MediaShareExtraInfo mediaShareExtraInfo5 = this.shareExtraInfo;
        if (mediaShareExtraInfo5 != null) {
            str5 = mediaShareExtraInfo5.getSessionId();
        }
        if (str5 == null || str5.length() == 0) {
            z18 = true;
        }
        if (!z18) {
            MediaShareExtraInfo mediaShareExtraInfo6 = this.shareExtraInfo;
            if (mediaShareExtraInfo6 != null && (sessionId = mediaShareExtraInfo6.getSessionId()) != null) {
                str6 = sessionId;
            }
            bundle.putString(AppConstants.Key.GUILD_MEDIA_ARK_CUSTOM_SESSION_ID, str6);
        }
        if (!bundle.isEmpty()) {
            x(bundle);
        }
    }

    public final void X(@NotNull d callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.shareCallback = callback;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.share.m
    public void g() {
        int i3;
        Job f16;
        if (this.isDismiss) {
            return;
        }
        int i16 = this.shareClickAction;
        if (i16 != 0) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        int T = T(i16);
        d dVar = this.shareCallback;
        if (dVar != null) {
            dVar.a(i3, T);
        }
        com.tencent.mobileqq.qcoroutine.api.coroutine.b bVar = this.requestShortJob;
        if (bVar != null && (f16 = bVar.f()) != null) {
            Job.DefaultImpls.cancel$default(f16, (CancellationException) null, 1, (Object) null);
        }
        V();
        Logger.f235387a.d().d("GuildMediaShareActionSheet", 1, "[dispatchDismiss] scene " + this.shareScene + ", code " + i3 + ", shareType " + T);
        super.g();
        this.isDismiss = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.share.m
    public void m(int action) {
        Job f16;
        Logger.f235387a.d().d("GuildMediaShareActionSheet", 1, "[handleShareAction] action " + action);
        this.shareClickAction = action;
        com.tencent.mobileqq.qcoroutine.api.coroutine.b bVar = this.requestShortJob;
        if (bVar != null && (f16 = bVar.f()) != null) {
            Job.DefaultImpls.cancel$default(f16, (CancellationException) null, 1, (Object) null);
        }
        HashMap<Integer, Integer> hashMap = E;
        boolean containsKey = hashMap.containsKey(Integer.valueOf(action));
        Integer num = hashMap.get(Integer.valueOf(action));
        if (!containsKey) {
            super.m(action);
            return;
        }
        Dialog showOnlyLoadingImageDialog = LoadingUtil.showOnlyLoadingImageDialog(this.f235047b.get(), 1, false);
        this.shareDialog = showOnlyLoadingImageDialog;
        if (showOnlyLoadingImageDialog != null) {
            showOnlyLoadingImageDialog.show();
        }
        this.requestShortJob = CorountineFunKt.e(j.b(), "requestShortJob", Boolean.TRUE, null, null, new GuildMediaShareActionSheet$handleShareAction$2(this, num, action, null), 12, null);
    }

    @Override // com.tencent.mobileqq.guild.share.m
    public void z() {
        super.z();
        ShareActionSheet shareActionSheet = this.f235061p;
        if (shareActionSheet != null) {
            shareActionSheet.setCancelListener(this.shareCancelListener);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildMediaShareActionSheet(@NotNull Activity activity, @NotNull IGProGuildInfo guildInfo, @Nullable IGProChannelInfo iGProChannelInfo, @NotNull ShareScene scene, @NotNull String shareSceneId) {
        super(activity, guildInfo, iGProChannelInfo, GuildSharePageSource.AUDIO_TOP_INVITE, shareSceneId, null);
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(guildInfo, "guildInfo");
        Intrinsics.checkNotNullParameter(scene, "scene");
        Intrinsics.checkNotNullParameter(shareSceneId, "shareSceneId");
        this.shareCancelListener = new c();
        this.shareScene = scene;
    }
}
