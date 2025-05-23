package com.tencent.videocut.model;

import android.os.Parcelable;
import androidx.fragment.app.a;
import com.squareup.wire.AndroidMessage;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0006\u0018\u0000 \u001d2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001c\u001dBs\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0004\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u00a2\u0006\u0002\u0010\u0013J\u008d\u0001\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u00a2\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\r2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0096\u0002J\b\u0010\u0019\u001a\u00020\u0007H\u0016J\b\u0010\u001a\u001a\u00020\u0002H\u0016J\b\u0010\u001b\u001a\u00020\u0004H\u0016R\u0010\u0010\u0010\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u00020\r8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/videocut/model/TransitionModel;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/videocut/model/TransitionModel$Builder;", "id", "", "path", "position", "", "duration", "", "landscapePagPath", "pagPath", MiniChatConstants.MINI_APP_LANDSCAPE, "", "resId", "relatedClipId", "categoryId", "unknownFields", "Lokio/ByteString;", "(Ljava/lang/String;Ljava/lang/String;IJLjava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lokio/ByteString;)V", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lokio/ByteString;)Lcom/tencent/videocut/model/TransitionModel;", "equals", "other", "", "hashCode", "newBuilder", "toString", "Builder", "Companion", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class TransitionModel extends AndroidMessage<TransitionModel, Builder> {
    static IPatchRedirector $redirector_;

    @JvmField
    @NotNull
    public static final ProtoAdapter<TransitionModel> ADAPTER;

    @JvmField
    @NotNull
    public static final Parcelable.Creator<TransitionModel> CREATOR;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 10)
    @JvmField
    @NotNull
    public final String categoryId;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 4)
    @JvmField
    public final long duration;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    @JvmField
    @NotNull
    public final String id;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 7)
    @JvmField
    public final boolean isLandscape;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 5)
    @JvmField
    @NotNull
    public final String landscapePagPath;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 6)
    @JvmField
    @NotNull
    public final String pagPath;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    @JvmField
    @NotNull
    public final String path;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 3)
    @JvmField
    public final int position;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 9)
    @JvmField
    @NotNull
    public final String relatedClipId;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 8)
    @JvmField
    @NotNull
    public final String resId;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0013\u001a\u00020\u0002H\u0016J\u0010\u0010\u0004\u001a\u00020\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005J\u0015\u0010\u0006\u001a\u00020\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010\u0014J\u0010\u0010\b\u001a\u00020\u00002\b\u0010\b\u001a\u0004\u0018\u00010\u0005J\u0015\u0010\t\u001a\u00020\u00002\b\u0010\t\u001a\u0004\u0018\u00010\n\u00a2\u0006\u0002\u0010\u0015J\u0010\u0010\f\u001a\u00020\u00002\b\u0010\f\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\r\u001a\u00020\u00002\b\u0010\r\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\u000e\u001a\u00020\u00002\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005J\u0015\u0010\u000f\u001a\u00020\u00002\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u00a2\u0006\u0002\u0010\u0016J\u0010\u0010\u0011\u001a\u00020\u00002\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\u0012\u001a\u00020\u00002\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u000bR\u0012\u0010\f\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/videocut/model/TransitionModel$Builder;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/videocut/model/TransitionModel;", "()V", "categoryId", "", "duration", "", "id", MiniChatConstants.MINI_APP_LANDSCAPE, "", "Ljava/lang/Boolean;", "landscapePagPath", "pagPath", "path", "position", "", "relatedClipId", "resId", "build", "(Ljava/lang/Long;)Lcom/tencent/videocut/model/TransitionModel$Builder;", "(Ljava/lang/Boolean;)Lcom/tencent/videocut/model/TransitionModel$Builder;", "(Ljava/lang/Integer;)Lcom/tencent/videocut/model/TransitionModel$Builder;", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final class Builder extends Message.Builder<TransitionModel, Builder> {
        static IPatchRedirector $redirector_;

        @JvmField
        @NotNull
        public String categoryId;

        @JvmField
        public long duration;

        @JvmField
        @NotNull
        public String id;

        @JvmField
        @Nullable
        public Boolean isLandscape;

        @JvmField
        @NotNull
        public String landscapePagPath;

        @JvmField
        @NotNull
        public String pagPath;

        @JvmField
        @NotNull
        public String path;

        @JvmField
        public int position;

        @JvmField
        @NotNull
        public String relatedClipId;

        @JvmField
        @NotNull
        public String resId;

        public Builder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.id = "";
            this.path = "";
            this.landscapePagPath = "";
            this.pagPath = "";
            this.resId = "";
            this.relatedClipId = "";
            this.categoryId = "";
        }

        @NotNull
        public final Builder categoryId(@Nullable String categoryId) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return (Builder) iPatchRedirector.redirect((short) 11, (Object) this, (Object) categoryId);
            }
            if (categoryId == null) {
                categoryId = "";
            }
            this.categoryId = categoryId;
            return this;
        }

        @NotNull
        public final Builder duration(@Nullable Long duration) {
            long j3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (Builder) iPatchRedirector.redirect((short) 5, (Object) this, (Object) duration);
            }
            if (duration != null) {
                j3 = duration.longValue();
            } else {
                j3 = 0;
            }
            this.duration = j3;
            return this;
        }

        @NotNull
        public final Builder id(@Nullable String id5) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Builder) iPatchRedirector.redirect((short) 2, (Object) this, (Object) id5);
            }
            if (id5 == null) {
                id5 = "";
            }
            this.id = id5;
            return this;
        }

        @NotNull
        public final Builder isLandscape(@Nullable Boolean isLandscape) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (Builder) iPatchRedirector.redirect((short) 8, (Object) this, (Object) isLandscape);
            }
            this.isLandscape = isLandscape;
            return this;
        }

        @NotNull
        public final Builder landscapePagPath(@Nullable String landscapePagPath) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (Builder) iPatchRedirector.redirect((short) 6, (Object) this, (Object) landscapePagPath);
            }
            if (landscapePagPath == null) {
                landscapePagPath = "";
            }
            this.landscapePagPath = landscapePagPath;
            return this;
        }

        @NotNull
        public final Builder pagPath(@Nullable String pagPath) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (Builder) iPatchRedirector.redirect((short) 7, (Object) this, (Object) pagPath);
            }
            if (pagPath == null) {
                pagPath = "";
            }
            this.pagPath = pagPath;
            return this;
        }

        @NotNull
        public final Builder path(@Nullable String path) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Builder) iPatchRedirector.redirect((short) 3, (Object) this, (Object) path);
            }
            if (path == null) {
                path = "";
            }
            this.path = path;
            return this;
        }

        @NotNull
        public final Builder position(@Nullable Integer position) {
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (Builder) iPatchRedirector.redirect((short) 4, (Object) this, (Object) position);
            }
            if (position != null) {
                i3 = position.intValue();
            } else {
                i3 = 0;
            }
            this.position = i3;
            return this;
        }

        @NotNull
        public final Builder relatedClipId(@Nullable String relatedClipId) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return (Builder) iPatchRedirector.redirect((short) 10, (Object) this, (Object) relatedClipId);
            }
            if (relatedClipId == null) {
                relatedClipId = "";
            }
            this.relatedClipId = relatedClipId;
            return this;
        }

        @NotNull
        public final Builder resId(@Nullable String resId) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (Builder) iPatchRedirector.redirect((short) 9, (Object) this, (Object) resId);
            }
            if (resId == null) {
                resId = "";
            }
            this.resId = resId;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        @NotNull
        public TransitionModel build() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return (TransitionModel) iPatchRedirector.redirect((short) 12, (Object) this);
            }
            String str = this.id;
            String str2 = this.path;
            int i3 = this.position;
            long j3 = this.duration;
            String str3 = this.landscapePagPath;
            String str4 = this.pagPath;
            Boolean bool = this.isLandscape;
            return new TransitionModel(str, str2, i3, j3, str3, str4, bool != null ? bool.booleanValue() : false, this.resId, this.relatedClipId, this.categoryId, buildUnknownFields());
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/tencent/videocut/model/TransitionModel$Companion;", "", "()V", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/tencent/videocut/model/TransitionModel;", "CREATOR", "Landroid/os/Parcelable$Creator;", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59379);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
            return;
        }
        INSTANCE = new Companion(null);
        final FieldEncoding fieldEncoding = FieldEncoding.LENGTH_DELIMITED;
        final KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(TransitionModel.class);
        ProtoAdapter<TransitionModel> protoAdapter = new ProtoAdapter<TransitionModel>(fieldEncoding, orCreateKotlinClass) { // from class: com.tencent.videocut.model.TransitionModel$Companion$ADAPTER$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(fieldEncoding, orCreateKotlinClass, "type.googleapis.com/publisher.TransitionModel");
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) fieldEncoding, (Object) orCreateKotlinClass);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            public TransitionModel decode(@NotNull ProtoReader reader) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    return (TransitionModel) iPatchRedirector.redirect((short) 4, (Object) this, (Object) reader);
                }
                Intrinsics.checkNotNullParameter(reader, "reader");
                long beginMessage = reader.beginMessage();
                String str = "";
                int i3 = 0;
                String str2 = "";
                String str3 = str2;
                String str4 = str3;
                long j3 = 0;
                Boolean bool = null;
                String str5 = str4;
                String str6 = str5;
                String str7 = str6;
                while (true) {
                    int nextTag = reader.nextTag();
                    if (nextTag != -1) {
                        switch (nextTag) {
                            case 1:
                                str = ProtoAdapter.STRING.decode(reader);
                                break;
                            case 2:
                                str5 = ProtoAdapter.STRING.decode(reader);
                                break;
                            case 3:
                                i3 = ProtoAdapter.INT32.decode(reader).intValue();
                                break;
                            case 4:
                                j3 = ProtoAdapter.INT64.decode(reader).longValue();
                                break;
                            case 5:
                                str6 = ProtoAdapter.STRING.decode(reader);
                                break;
                            case 6:
                                str7 = ProtoAdapter.STRING.decode(reader);
                                break;
                            case 7:
                                bool = ProtoAdapter.BOOL.decode(reader);
                                break;
                            case 8:
                                str2 = ProtoAdapter.STRING.decode(reader);
                                break;
                            case 9:
                                str3 = ProtoAdapter.STRING.decode(reader);
                                break;
                            case 10:
                                str4 = ProtoAdapter.STRING.decode(reader);
                                break;
                            default:
                                reader.readUnknownField(nextTag);
                                break;
                        }
                    } else {
                        Boolean bool2 = bool;
                        return new TransitionModel(str, str5, i3, j3, str6, str7, bool2 != null ? bool2.booleanValue() : false, str2, str3, str4, reader.endMessageAndGetUnknownFields(beginMessage));
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(@NotNull ProtoWriter writer, @NotNull TransitionModel value) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this, (Object) writer, (Object) value);
                    return;
                }
                Intrinsics.checkNotNullParameter(writer, "writer");
                Intrinsics.checkNotNullParameter(value, "value");
                ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                protoAdapter2.encodeWithTag(writer, 1, value.id);
                protoAdapter2.encodeWithTag(writer, 2, value.path);
                ProtoAdapter.INT32.encodeWithTag(writer, 3, Integer.valueOf(value.position));
                ProtoAdapter.INT64.encodeWithTag(writer, 4, Long.valueOf(value.duration));
                protoAdapter2.encodeWithTag(writer, 5, value.landscapePagPath);
                protoAdapter2.encodeWithTag(writer, 6, value.pagPath);
                ProtoAdapter.BOOL.encodeWithTag(writer, 7, Boolean.valueOf(value.isLandscape));
                protoAdapter2.encodeWithTag(writer, 8, value.resId);
                protoAdapter2.encodeWithTag(writer, 9, value.relatedClipId);
                protoAdapter2.encodeWithTag(writer, 10, value.categoryId);
                writer.writeBytes(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(@NotNull TransitionModel value) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) value)).intValue();
                }
                Intrinsics.checkNotNullParameter(value, "value");
                ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                return protoAdapter2.encodedSizeWithTag(1, value.id) + protoAdapter2.encodedSizeWithTag(2, value.path) + ProtoAdapter.INT32.encodedSizeWithTag(3, Integer.valueOf(value.position)) + ProtoAdapter.INT64.encodedSizeWithTag(4, Long.valueOf(value.duration)) + protoAdapter2.encodedSizeWithTag(5, value.landscapePagPath) + protoAdapter2.encodedSizeWithTag(6, value.pagPath) + ProtoAdapter.BOOL.encodedSizeWithTag(7, Boolean.valueOf(value.isLandscape)) + protoAdapter2.encodedSizeWithTag(8, value.resId) + protoAdapter2.encodedSizeWithTag(9, value.relatedClipId) + protoAdapter2.encodedSizeWithTag(10, value.categoryId) + value.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            public TransitionModel redact(@NotNull TransitionModel value) {
                TransitionModel copy;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                    return (TransitionModel) iPatchRedirector.redirect((short) 5, (Object) this, (Object) value);
                }
                Intrinsics.checkNotNullParameter(value, "value");
                copy = value.copy((r24 & 1) != 0 ? value.id : null, (r24 & 2) != 0 ? value.path : null, (r24 & 4) != 0 ? Integer.valueOf(value.position) : null, (r24 & 8) != 0 ? Long.valueOf(value.duration) : null, (r24 & 16) != 0 ? value.landscapePagPath : null, (r24 & 32) != 0 ? value.pagPath : null, (r24 & 64) != 0 ? Boolean.valueOf(value.isLandscape) : null, (r24 & 128) != 0 ? value.resId : null, (r24 & 256) != 0 ? value.relatedClipId : null, (r24 & 512) != 0 ? value.categoryId : null, (r24 & 1024) != 0 ? value.unknownFields() : ByteString.EMPTY);
                return copy;
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = AndroidMessage.INSTANCE.newCreator(protoAdapter);
    }

    public TransitionModel() {
        this(null, null, 0, 0L, null, null, false, null, null, null, null, 2047, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
            return;
        }
        iPatchRedirector.redirect((short) 8, (Object) this);
    }

    @NotNull
    public final TransitionModel copy(@Nullable String id5, @Nullable String path, @Nullable Integer position, @Nullable Long duration, @Nullable String landscapePagPath, @Nullable String pagPath, @Nullable Boolean isLandscape, @Nullable String resId, @Nullable String relatedClipId, @Nullable String categoryId, @NotNull ByteString unknownFields) {
        String str;
        String str2;
        int i3;
        long j3;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (TransitionModel) iPatchRedirector.redirect((short) 7, this, id5, path, position, duration, landscapePagPath, pagPath, isLandscape, resId, relatedClipId, categoryId, unknownFields);
        }
        Intrinsics.checkNotNullParameter(unknownFields, "unknownFields");
        if (id5 == null) {
            str = "";
        } else {
            str = id5;
        }
        if (path == null) {
            str2 = "";
        } else {
            str2 = path;
        }
        if (position != null) {
            i3 = position.intValue();
        } else {
            i3 = 0;
        }
        if (duration != null) {
            j3 = duration.longValue();
        } else {
            j3 = 0;
        }
        if (landscapePagPath == null) {
            str3 = "";
        } else {
            str3 = landscapePagPath;
        }
        if (pagPath == null) {
            str4 = "";
        } else {
            str4 = pagPath;
        }
        if (isLandscape != null) {
            z16 = isLandscape.booleanValue();
        }
        boolean z17 = z16;
        if (resId == null) {
            str5 = "";
        } else {
            str5 = resId;
        }
        if (relatedClipId == null) {
            str6 = "";
        } else {
            str6 = relatedClipId;
        }
        if (categoryId == null) {
            str7 = "";
        } else {
            str7 = categoryId;
        }
        return new TransitionModel(str, str2, i3, j3, str3, str4, z17, str5, str6, str7, unknownFields);
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, other)).booleanValue();
        }
        if (other == this) {
            return true;
        }
        if (!(other instanceof TransitionModel)) {
            return false;
        }
        TransitionModel transitionModel = (TransitionModel) other;
        if (Intrinsics.areEqual(unknownFields(), transitionModel.unknownFields()) && Intrinsics.areEqual(this.id, transitionModel.id) && Intrinsics.areEqual(this.path, transitionModel.path) && this.position == transitionModel.position && this.duration == transitionModel.duration && Intrinsics.areEqual(this.landscapePagPath, transitionModel.landscapePagPath) && Intrinsics.areEqual(this.pagPath, transitionModel.pagPath) && this.isLandscape == transitionModel.isLandscape && Intrinsics.areEqual(this.resId, transitionModel.resId) && Intrinsics.areEqual(this.relatedClipId, transitionModel.relatedClipId) && Intrinsics.areEqual(this.categoryId, transitionModel.categoryId)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        int i3 = this.hashCode;
        if (i3 == 0) {
            int hashCode = (((((((((((((((((((unknownFields().hashCode() * 37) + this.id.hashCode()) * 37) + this.path.hashCode()) * 37) + this.position) * 37) + a.a(this.duration)) * 37) + this.landscapePagPath.hashCode()) * 37) + this.pagPath.hashCode()) * 37) + com.tencent.aio.widget.textView.param.a.a(this.isLandscape)) * 37) + this.resId.hashCode()) * 37) + this.relatedClipId.hashCode()) * 37) + this.categoryId.hashCode();
            this.hashCode = hashCode;
            return hashCode;
        }
        return i3;
    }

    @Override // com.squareup.wire.Message
    @NotNull
    public String toString() {
        String joinToString$default;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        ArrayList arrayList = new ArrayList();
        String str = this.id;
        if (str != null) {
            arrayList.add("id=" + Internal.sanitize(str));
        }
        String str2 = this.path;
        if (str2 != null) {
            arrayList.add("path=" + Internal.sanitize(str2));
        }
        arrayList.add("position=" + this.position);
        arrayList.add("duration=" + this.duration);
        String str3 = this.landscapePagPath;
        if (str3 != null) {
            arrayList.add("landscapePagPath=" + Internal.sanitize(str3));
        }
        String str4 = this.pagPath;
        if (str4 != null) {
            arrayList.add("pagPath=" + Internal.sanitize(str4));
        }
        arrayList.add("isLandscape=" + this.isLandscape);
        String str5 = this.resId;
        if (str5 != null) {
            arrayList.add("resId=" + Internal.sanitize(str5));
        }
        String str6 = this.relatedClipId;
        if (str6 != null) {
            arrayList.add("relatedClipId=" + Internal.sanitize(str6));
        }
        String str7 = this.categoryId;
        if (str7 != null) {
            arrayList.add("categoryId=" + Internal.sanitize(str7));
        }
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, ", ", "TransitionModel{", "}", 0, null, null, 56, null);
        return joinToString$default;
    }

    public /* synthetic */ TransitionModel(String str, String str2, int i3, long j3, String str3, String str4, boolean z16, String str5, String str6, String str7, ByteString byteString, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? "" : str, (i16 & 2) != 0 ? "" : str2, (i16 & 4) != 0 ? 0 : i3, (i16 & 8) != 0 ? 0L : j3, (i16 & 16) != 0 ? "" : str3, (i16 & 32) != 0 ? "" : str4, (i16 & 64) != 0 ? false : z16, (i16 & 128) != 0 ? "" : str5, (i16 & 256) != 0 ? "" : str6, (i16 & 512) != 0 ? "" : str7, (i16 & 1024) != 0 ? ByteString.EMPTY : byteString);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, str, str2, Integer.valueOf(i3), Long.valueOf(j3), str3, str4, Boolean.valueOf(z16), str5, str6, str7, byteString, Integer.valueOf(i16), defaultConstructorMarker);
    }

    @Override // com.squareup.wire.Message
    @NotNull
    public Builder newBuilder() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Builder) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        Builder builder = new Builder();
        builder.id = this.id;
        builder.path = this.path;
        builder.position = this.position;
        builder.duration = this.duration;
        builder.landscapePagPath = this.landscapePagPath;
        builder.pagPath = this.pagPath;
        builder.isLandscape = Boolean.valueOf(this.isLandscape);
        builder.resId = this.resId;
        builder.relatedClipId = this.relatedClipId;
        builder.categoryId = this.categoryId;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TransitionModel(@NotNull String id5, @NotNull String path, int i3, long j3, @NotNull String landscapePagPath, @NotNull String pagPath, boolean z16, @NotNull String resId, @NotNull String relatedClipId, @NotNull String categoryId, @NotNull ByteString unknownFields) {
        super(ADAPTER, unknownFields);
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(landscapePagPath, "landscapePagPath");
        Intrinsics.checkNotNullParameter(pagPath, "pagPath");
        Intrinsics.checkNotNullParameter(resId, "resId");
        Intrinsics.checkNotNullParameter(relatedClipId, "relatedClipId");
        Intrinsics.checkNotNullParameter(categoryId, "categoryId");
        Intrinsics.checkNotNullParameter(unknownFields, "unknownFields");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, id5, path, Integer.valueOf(i3), Long.valueOf(j3), landscapePagPath, pagPath, Boolean.valueOf(z16), resId, relatedClipId, categoryId, unknownFields);
            return;
        }
        this.id = id5;
        this.path = path;
        this.position = i3;
        this.duration = j3;
        this.landscapePagPath = landscapePagPath;
        this.pagPath = pagPath;
        this.isLandscape = z16;
        this.resId = resId;
        this.relatedClipId = relatedClipId;
        this.categoryId = categoryId;
    }
}
