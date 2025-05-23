package com.tencent.videocut.model;

import android.os.Parcelable;
import com.squareup.wire.AndroidMessage;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\u0018\u0000  2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001f B\u0081\u0001\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0004\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0015\u00a2\u0006\u0002\u0010\u0016J\u0084\u0001\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u0015J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0096\u0002J\b\u0010\u001c\u001a\u00020\u0013H\u0016J\b\u0010\u001d\u001a\u00020\u0002H\u0016J\b\u0010\u001e\u001a\u00020\u0004H\u0016R\u0010\u0010\t\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u00020\u00118\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u00020\u00138\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006!"}, d2 = {"Lcom/tencent/videocut/model/BackgroundModel;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/videocut/model/BackgroundModel$Builder;", "id", "", "renderSize", "Lcom/tencent/videocut/model/SizeF;", "bgFillMode", "Lcom/tencent/videocut/model/BackgroundFillMode;", "bgColor", "bgPagPath", "ratioType", "Lcom/tencent/videocut/model/RatioType;", "resPack", "Lcom/tencent/videocut/model/BackgroundResPack;", "categoryId", "fillScale", "", "imageEffect", "", "unknownFields", "Lokio/ByteString;", "(Ljava/lang/String;Lcom/tencent/videocut/model/SizeF;Lcom/tencent/videocut/model/BackgroundFillMode;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/videocut/model/RatioType;Lcom/tencent/videocut/model/BackgroundResPack;Ljava/lang/String;FILokio/ByteString;)V", "copy", "equals", "", "other", "", "hashCode", "newBuilder", "toString", "Builder", "Companion", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class BackgroundModel extends AndroidMessage<BackgroundModel, Builder> {
    static IPatchRedirector $redirector_;

    @JvmField
    @NotNull
    public static final ProtoAdapter<BackgroundModel> ADAPTER;

    @JvmField
    @NotNull
    public static final Parcelable.Creator<BackgroundModel> CREATOR;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    @JvmField
    @NotNull
    public final String bgColor;

    @WireField(adapter = "com.tencent.videocut.model.BackgroundFillMode#ADAPTER", tag = 3)
    @JvmField
    @Nullable
    public final BackgroundFillMode bgFillMode;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 5)
    @JvmField
    @Nullable
    public final String bgPagPath;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 8)
    @JvmField
    @Nullable
    public final String categoryId;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 9)
    @JvmField
    public final float fillScale;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    @JvmField
    @Nullable
    public final String id;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 9)
    @JvmField
    public final int imageEffect;

    @WireField(adapter = "com.tencent.videocut.model.RatioType#ADAPTER", tag = 6)
    @JvmField
    @Nullable
    public final RatioType ratioType;

    @WireField(adapter = "com.tencent.videocut.model.SizeF#ADAPTER", tag = 2)
    @JvmField
    @Nullable
    public final SizeF renderSize;

    @WireField(adapter = "com.tencent.videocut.model.BackgroundResPack#ADAPTER", tag = 7)
    @JvmField
    @Nullable
    public final BackgroundResPack resPack;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\u0006\u001a\u00020\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007J\u0010\u0010\b\u001a\u00020\u00002\b\u0010\b\u001a\u0004\u0018\u00010\u0005J\b\u0010\u0015\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00002\b\u0010\t\u001a\u0004\u0018\u00010\u0005J\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u000bJ\u0010\u0010\f\u001a\u00020\u00002\b\u0010\f\u001a\u0004\u0018\u00010\u0005J\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u000eJ\u0010\u0010\u000f\u001a\u00020\u00002\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010J\u0010\u0010\u0011\u001a\u00020\u00002\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012J\u0010\u0010\u0013\u001a\u00020\u00002\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014R\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/videocut/model/BackgroundModel$Builder;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/videocut/model/BackgroundModel;", "()V", "bgColor", "", "bgFillMode", "Lcom/tencent/videocut/model/BackgroundFillMode;", "bgPagPath", "categoryId", "fillScale", "", "id", "imageEffect", "", "ratioType", "Lcom/tencent/videocut/model/RatioType;", "renderSize", "Lcom/tencent/videocut/model/SizeF;", "resPack", "Lcom/tencent/videocut/model/BackgroundResPack;", "build", "scale", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final class Builder extends Message.Builder<BackgroundModel, Builder> {
        static IPatchRedirector $redirector_;

        @JvmField
        @Nullable
        public String bgColor;

        @JvmField
        @Nullable
        public BackgroundFillMode bgFillMode;

        @JvmField
        @Nullable
        public String bgPagPath;

        @JvmField
        @Nullable
        public String categoryId;

        @JvmField
        public float fillScale;

        @JvmField
        @Nullable
        public String id;

        @JvmField
        public int imageEffect;

        @JvmField
        @Nullable
        public RatioType ratioType;

        @JvmField
        @Nullable
        public SizeF renderSize;

        @JvmField
        @Nullable
        public BackgroundResPack resPack;

        public Builder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @NotNull
        public final Builder bgColor(@Nullable String bgColor) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (Builder) iPatchRedirector.redirect((short) 5, (Object) this, (Object) bgColor);
            }
            this.bgColor = bgColor;
            return this;
        }

        @NotNull
        public final Builder bgFillMode(@Nullable BackgroundFillMode bgFillMode) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (Builder) iPatchRedirector.redirect((short) 4, (Object) this, (Object) bgFillMode);
            }
            this.bgFillMode = bgFillMode;
            return this;
        }

        @NotNull
        public final Builder bgPagPath(@Nullable String bgPagPath) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (Builder) iPatchRedirector.redirect((short) 6, (Object) this, (Object) bgPagPath);
            }
            this.bgPagPath = bgPagPath;
            return this;
        }

        @NotNull
        public final Builder categoryId(@Nullable String categoryId) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (Builder) iPatchRedirector.redirect((short) 9, (Object) this, (Object) categoryId);
            }
            this.categoryId = categoryId;
            return this;
        }

        @NotNull
        public final Builder fillScale(float scale) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return (Builder) iPatchRedirector.redirect((short) 10, this, Float.valueOf(scale));
            }
            this.fillScale = this.fillScale;
            return this;
        }

        @NotNull
        public final Builder id(@Nullable String id5) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Builder) iPatchRedirector.redirect((short) 2, (Object) this, (Object) id5);
            }
            this.id = id5;
            return this;
        }

        @NotNull
        public final Builder imageEffect(int imageEffect) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return (Builder) iPatchRedirector.redirect((short) 11, (Object) this, imageEffect);
            }
            this.imageEffect = imageEffect;
            return this;
        }

        @NotNull
        public final Builder ratioType(@Nullable RatioType ratioType) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (Builder) iPatchRedirector.redirect((short) 7, (Object) this, (Object) ratioType);
            }
            this.ratioType = ratioType;
            return this;
        }

        @NotNull
        public final Builder renderSize(@Nullable SizeF renderSize) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Builder) iPatchRedirector.redirect((short) 3, (Object) this, (Object) renderSize);
            }
            this.renderSize = renderSize;
            return this;
        }

        @NotNull
        public final Builder resPack(@Nullable BackgroundResPack resPack) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (Builder) iPatchRedirector.redirect((short) 8, (Object) this, (Object) resPack);
            }
            this.resPack = resPack;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        @NotNull
        public BackgroundModel build() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return (BackgroundModel) iPatchRedirector.redirect((short) 12, (Object) this);
            }
            String str = this.id;
            SizeF sizeF = this.renderSize;
            BackgroundFillMode backgroundFillMode = this.bgFillMode;
            String str2 = this.bgColor;
            if (str2 == null) {
                str2 = "";
            }
            return new BackgroundModel(str, sizeF, backgroundFillMode, str2, this.bgPagPath, this.ratioType, this.resPack, this.categoryId, this.fillScale, this.imageEffect, buildUnknownFields());
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/tencent/videocut/model/BackgroundModel$Companion;", "", "()V", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/tencent/videocut/model/BackgroundModel;", "CREATOR", "Landroid/os/Parcelable$Creator;", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(58485);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
            return;
        }
        INSTANCE = new Companion(null);
        ProtoAdapter<BackgroundModel> protoAdapter = new ProtoAdapter<BackgroundModel>(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(BackgroundModel.class)) { // from class: com.tencent.videocut.model.BackgroundModel$Companion$ADAPTER$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(r4, r5, "type.googleapis.com/publisher.BackgroundModel");
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) r4, (Object) r5);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Failed to find 'out' block for switch in B:11:0x0038. Please report as an issue. */
            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            public BackgroundModel decode(@NotNull ProtoReader reader) {
                BackgroundResPack backgroundResPack;
                String str;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    return (BackgroundModel) iPatchRedirector.redirect((short) 4, (Object) this, (Object) reader);
                }
                Intrinsics.checkNotNullParameter(reader, "reader");
                long beginMessage = reader.beginMessage();
                BackgroundFillMode backgroundFillMode = null;
                String str2 = null;
                String str3 = null;
                RatioType ratioType = null;
                BackgroundResPack backgroundResPack2 = null;
                String str4 = null;
                float f16 = 0.0f;
                int i3 = 0;
                String str5 = null;
                SizeF sizeF = null;
                while (true) {
                    int nextTag = reader.nextTag();
                    if (nextTag != -1) {
                        switch (nextTag) {
                            case 1:
                                str5 = ProtoAdapter.STRING.decode(reader);
                                break;
                            case 2:
                                sizeF = SizeF.ADAPTER.decode(reader);
                                break;
                            case 3:
                                backgroundResPack = backgroundResPack2;
                                str = str4;
                                try {
                                    backgroundFillMode = BackgroundFillMode.ADAPTER.decode(reader);
                                    str4 = str;
                                } catch (ProtoAdapter.EnumConstantNotFoundException e16) {
                                    str4 = str;
                                    reader.addUnknownField(nextTag, FieldEncoding.VARINT, Long.valueOf(e16.value));
                                }
                                backgroundResPack2 = backgroundResPack;
                                break;
                            case 4:
                                str2 = ProtoAdapter.STRING.decode(reader);
                                break;
                            case 5:
                                str3 = ProtoAdapter.STRING.decode(reader);
                                break;
                            case 6:
                                try {
                                    ratioType = RatioType.ADAPTER.decode(reader);
                                    break;
                                } catch (ProtoAdapter.EnumConstantNotFoundException e17) {
                                    backgroundResPack = backgroundResPack2;
                                    str = str4;
                                    reader.addUnknownField(nextTag, FieldEncoding.VARINT, Long.valueOf(e17.value));
                                    break;
                                }
                            case 7:
                                backgroundResPack2 = BackgroundResPack.ADAPTER.decode(reader);
                                break;
                            case 8:
                                str4 = ProtoAdapter.STRING.decode(reader);
                                break;
                            case 9:
                                f16 = ProtoAdapter.FLOAT.decode(reader).floatValue();
                                break;
                            case 10:
                                i3 = ProtoAdapter.INT32.decode(reader).intValue();
                                break;
                            default:
                                backgroundResPack = backgroundResPack2;
                                reader.readUnknownField(nextTag);
                                backgroundResPack2 = backgroundResPack;
                                break;
                        }
                    } else {
                        String str6 = str2;
                        return new BackgroundModel(str5, sizeF, backgroundFillMode, str6 == null ? "" : str6, str3, ratioType, backgroundResPack2, str4, f16, i3, reader.endMessageAndGetUnknownFields(beginMessage));
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(@NotNull ProtoWriter writer, @NotNull BackgroundModel value) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this, (Object) writer, (Object) value);
                    return;
                }
                Intrinsics.checkNotNullParameter(writer, "writer");
                Intrinsics.checkNotNullParameter(value, "value");
                ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                protoAdapter2.encodeWithTag(writer, 1, value.id);
                SizeF.ADAPTER.encodeWithTag(writer, 2, value.renderSize);
                BackgroundFillMode.ADAPTER.encodeWithTag(writer, 3, value.bgFillMode);
                protoAdapter2.encodeWithTag(writer, 4, value.bgColor);
                protoAdapter2.encodeWithTag(writer, 5, value.bgPagPath);
                RatioType.ADAPTER.encodeWithTag(writer, 6, value.ratioType);
                BackgroundResPack.ADAPTER.encodeWithTag(writer, 7, value.resPack);
                protoAdapter2.encodeWithTag(writer, 8, value.categoryId);
                ProtoAdapter.FLOAT.encodeWithTag(writer, 9, Float.valueOf(value.fillScale));
                ProtoAdapter.INT32.encodeWithTag(writer, 10, Integer.valueOf(value.imageEffect));
                writer.writeBytes(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(@NotNull BackgroundModel value) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) value)).intValue();
                }
                Intrinsics.checkNotNullParameter(value, "value");
                ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                return protoAdapter2.encodedSizeWithTag(1, value.id) + SizeF.ADAPTER.encodedSizeWithTag(2, value.renderSize) + BackgroundFillMode.ADAPTER.encodedSizeWithTag(3, value.bgFillMode) + protoAdapter2.encodedSizeWithTag(4, value.bgColor) + protoAdapter2.encodedSizeWithTag(5, value.bgPagPath) + RatioType.ADAPTER.encodedSizeWithTag(6, value.ratioType) + BackgroundResPack.ADAPTER.encodedSizeWithTag(7, value.resPack) + protoAdapter2.encodedSizeWithTag(8, value.categoryId) + ProtoAdapter.FLOAT.encodedSizeWithTag(9, Float.valueOf(value.fillScale)) + ProtoAdapter.INT32.encodedSizeWithTag(10, Integer.valueOf(value.imageEffect)) + value.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            public BackgroundModel redact(@NotNull BackgroundModel value) {
                BackgroundModel copy;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                    return (BackgroundModel) iPatchRedirector.redirect((short) 5, (Object) this, (Object) value);
                }
                Intrinsics.checkNotNullParameter(value, "value");
                SizeF sizeF = value.renderSize;
                SizeF redact = sizeF != null ? SizeF.ADAPTER.redact(sizeF) : null;
                BackgroundResPack backgroundResPack = value.resPack;
                copy = value.copy((r24 & 1) != 0 ? value.id : null, (r24 & 2) != 0 ? value.renderSize : redact, (r24 & 4) != 0 ? value.bgFillMode : null, (r24 & 8) != 0 ? value.bgColor : null, (r24 & 16) != 0 ? value.bgPagPath : null, (r24 & 32) != 0 ? value.ratioType : null, (r24 & 64) != 0 ? value.resPack : backgroundResPack != null ? BackgroundResPack.ADAPTER.redact(backgroundResPack) : null, (r24 & 128) != 0 ? value.categoryId : null, (r24 & 256) != 0 ? value.fillScale : 0.0f, (r24 & 512) != 0 ? value.imageEffect : 0, (r24 & 1024) != 0 ? value.unknownFields() : ByteString.EMPTY);
                return copy;
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = AndroidMessage.INSTANCE.newCreator(protoAdapter);
    }

    public BackgroundModel() {
        this(null, null, null, null, null, null, null, null, 0.0f, 0, null, 2047, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
            return;
        }
        iPatchRedirector.redirect((short) 8, (Object) this);
    }

    public static /* synthetic */ BackgroundModel copy$default(BackgroundModel backgroundModel, String str, SizeF sizeF, BackgroundFillMode backgroundFillMode, String str2, String str3, RatioType ratioType, BackgroundResPack backgroundResPack, String str4, float f16, int i3, ByteString byteString, int i16, Object obj) {
        return backgroundModel.copy((i16 & 1) != 0 ? backgroundModel.id : str, (i16 & 2) != 0 ? backgroundModel.renderSize : sizeF, (i16 & 4) != 0 ? backgroundModel.bgFillMode : backgroundFillMode, (i16 & 8) != 0 ? backgroundModel.bgColor : str2, (i16 & 16) != 0 ? backgroundModel.bgPagPath : str3, (i16 & 32) != 0 ? backgroundModel.ratioType : ratioType, (i16 & 64) != 0 ? backgroundModel.resPack : backgroundResPack, (i16 & 128) != 0 ? backgroundModel.categoryId : str4, (i16 & 256) != 0 ? backgroundModel.fillScale : f16, (i16 & 512) != 0 ? backgroundModel.imageEffect : i3, (i16 & 1024) != 0 ? backgroundModel.unknownFields() : byteString);
    }

    @NotNull
    public final BackgroundModel copy(@Nullable String id5, @Nullable SizeF renderSize, @Nullable BackgroundFillMode bgFillMode, @Nullable String bgColor, @Nullable String bgPagPath, @Nullable RatioType ratioType, @Nullable BackgroundResPack resPack, @Nullable String categoryId, float fillScale, int imageEffect, @NotNull ByteString unknownFields) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (BackgroundModel) iPatchRedirector.redirect((short) 7, this, id5, renderSize, bgFillMode, bgColor, bgPagPath, ratioType, resPack, categoryId, Float.valueOf(fillScale), Integer.valueOf(imageEffect), unknownFields);
        }
        Intrinsics.checkNotNullParameter(unknownFields, "unknownFields");
        if (bgColor == null) {
            str = "";
        } else {
            str = bgColor;
        }
        return new BackgroundModel(id5, renderSize, bgFillMode, str, bgPagPath, ratioType, resPack, categoryId, fillScale, imageEffect, unknownFields);
    }

    public boolean equals(@Nullable Object other) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, other)).booleanValue();
        }
        if (other == this) {
            return true;
        }
        if (!(other instanceof BackgroundModel)) {
            return false;
        }
        BackgroundModel backgroundModel = (BackgroundModel) other;
        if (Intrinsics.areEqual(unknownFields(), backgroundModel.unknownFields()) && Intrinsics.areEqual(this.id, backgroundModel.id) && Intrinsics.areEqual(this.renderSize, backgroundModel.renderSize) && this.bgFillMode == backgroundModel.bgFillMode && Intrinsics.areEqual(this.bgColor, backgroundModel.bgColor) && Intrinsics.areEqual(this.bgPagPath, backgroundModel.bgPagPath) && this.ratioType == backgroundModel.ratioType && Intrinsics.areEqual(this.resPack, backgroundModel.resPack) && Intrinsics.areEqual(this.categoryId, backgroundModel.categoryId)) {
            if (this.fillScale == backgroundModel.fillScale) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16 && this.imageEffect == backgroundModel.imageEffect) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        int i26;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        int i27 = this.hashCode;
        if (i27 == 0) {
            int hashCode = unknownFields().hashCode() * 37;
            String str = this.id;
            int i28 = 0;
            if (str != null) {
                i3 = str.hashCode();
            } else {
                i3 = 0;
            }
            int i29 = (hashCode + i3) * 37;
            SizeF sizeF = this.renderSize;
            if (sizeF != null) {
                i16 = sizeF.hashCode();
            } else {
                i16 = 0;
            }
            int i36 = (i29 + i16) * 37;
            BackgroundFillMode backgroundFillMode = this.bgFillMode;
            if (backgroundFillMode != null) {
                i17 = backgroundFillMode.hashCode();
            } else {
                i17 = 0;
            }
            int hashCode2 = (((i36 + i17) * 37) + this.bgColor.hashCode()) * 37;
            String str2 = this.bgPagPath;
            if (str2 != null) {
                i18 = str2.hashCode();
            } else {
                i18 = 0;
            }
            int i37 = (hashCode2 + i18) * 37;
            RatioType ratioType = this.ratioType;
            if (ratioType != null) {
                i19 = ratioType.hashCode();
            } else {
                i19 = 0;
            }
            int i38 = (i37 + i19) * 37;
            BackgroundResPack backgroundResPack = this.resPack;
            if (backgroundResPack != null) {
                i26 = backgroundResPack.hashCode();
            } else {
                i26 = 0;
            }
            int i39 = (i38 + i26) * 37;
            String str3 = this.categoryId;
            if (str3 != null) {
                i28 = str3.hashCode();
            }
            int floatToIntBits = ((((i39 + i28) * 37) + Float.floatToIntBits(this.fillScale)) * 37) + this.imageEffect;
            this.hashCode = floatToIntBits;
            return floatToIntBits;
        }
        return i27;
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
        SizeF sizeF = this.renderSize;
        if (sizeF != null) {
            arrayList.add("renderSize=" + sizeF);
        }
        BackgroundFillMode backgroundFillMode = this.bgFillMode;
        if (backgroundFillMode != null) {
            arrayList.add("bgFillMode=" + backgroundFillMode);
        }
        String str2 = this.bgColor;
        if (str2 != null) {
            arrayList.add("bgColor=" + Internal.sanitize(str2));
        }
        String str3 = this.bgPagPath;
        if (str3 != null) {
            arrayList.add("bgPagPath=" + Internal.sanitize(str3));
        }
        RatioType ratioType = this.ratioType;
        if (ratioType != null) {
            arrayList.add("ratioType=" + ratioType);
        }
        BackgroundResPack backgroundResPack = this.resPack;
        if (backgroundResPack != null) {
            arrayList.add("resPack=" + backgroundResPack);
        }
        String str4 = this.categoryId;
        if (str4 != null) {
            arrayList.add("categoryId=" + Internal.sanitize(str4));
        }
        arrayList.add("fillScale=" + this.fillScale);
        arrayList.add("imageEffect=" + this.imageEffect);
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, ", ", "BackgroundModel{", "}", 0, null, null, 56, null);
        return joinToString$default;
    }

    public /* synthetic */ BackgroundModel(String str, SizeF sizeF, BackgroundFillMode backgroundFillMode, String str2, String str3, RatioType ratioType, BackgroundResPack backgroundResPack, String str4, float f16, int i3, ByteString byteString, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? null : str, (i16 & 2) != 0 ? null : sizeF, (i16 & 4) != 0 ? null : backgroundFillMode, (i16 & 8) != 0 ? "" : str2, (i16 & 16) != 0 ? null : str3, (i16 & 32) != 0 ? null : ratioType, (i16 & 64) != 0 ? null : backgroundResPack, (i16 & 128) != 0 ? null : str4, (i16 & 256) != 0 ? 0.0f : f16, (i16 & 512) != 0 ? 0 : i3, (i16 & 1024) != 0 ? ByteString.EMPTY : byteString);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, str, sizeF, backgroundFillMode, str2, str3, ratioType, backgroundResPack, str4, Float.valueOf(f16), Integer.valueOf(i3), byteString, Integer.valueOf(i16), defaultConstructorMarker);
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
        builder.renderSize = this.renderSize;
        builder.bgFillMode = this.bgFillMode;
        builder.bgColor = this.bgColor;
        builder.bgPagPath = this.bgPagPath;
        builder.ratioType = this.ratioType;
        builder.resPack = this.resPack;
        builder.categoryId = this.categoryId;
        builder.fillScale = this.fillScale;
        builder.imageEffect = this.imageEffect;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BackgroundModel(@Nullable String str, @Nullable SizeF sizeF, @Nullable BackgroundFillMode backgroundFillMode, @NotNull String bgColor, @Nullable String str2, @Nullable RatioType ratioType, @Nullable BackgroundResPack backgroundResPack, @Nullable String str3, float f16, int i3, @NotNull ByteString unknownFields) {
        super(ADAPTER, unknownFields);
        Intrinsics.checkNotNullParameter(bgColor, "bgColor");
        Intrinsics.checkNotNullParameter(unknownFields, "unknownFields");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, sizeF, backgroundFillMode, bgColor, str2, ratioType, backgroundResPack, str3, Float.valueOf(f16), Integer.valueOf(i3), unknownFields);
            return;
        }
        this.id = str;
        this.renderSize = sizeF;
        this.bgFillMode = backgroundFillMode;
        this.bgColor = bgColor;
        this.bgPagPath = str2;
        this.ratioType = ratioType;
        this.resPack = backgroundResPack;
        this.categoryId = str3;
        this.fillScale = f16;
        this.imageEffect = i3;
    }
}
