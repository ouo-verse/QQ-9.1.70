package com.tencent.tavcut.composition.model.component;

import android.os.Parcelable;
import com.squareup.wire.AndroidMessage;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0006\u0018\u0000 %2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002$%B\u00c3\u0001\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0017\u00a2\u0006\u0002\u0010\u0018J\u00c9\u0001\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0016\u001a\u00020\u0017\u00a2\u0006\u0002\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0096\u0002J\b\u0010!\u001a\u00020\u0011H\u0016J\b\u0010\"\u001a\u00020\u0002H\u0016J\b\u0010#\u001a\u00020\u0007H\u0016R\u0014\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0019R\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u001aR\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0019R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0019R\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u001aR\u0014\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u001bR\u0012\u0010\n\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0019R\u0014\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u001bR\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u001b\u00a8\u0006&"}, d2 = {"Lcom/tencent/tavcut/composition/model/component/TextReplaceItem;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/tavcut/composition/model/component/TextReplaceItem$Builder;", "fauxBold", "", "fauxItalic", "fontFamily", "", "fontPath", "applyStroke", "strokeColor", "strokeWidth", "", "leading", "tracking", "backgroundColor", "backgroundAlpha", "", "textColor", "justification", "fontStyle", "strokeOverFill", "unknownFields", "Lokio/ByteString;", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Lokio/ByteString;)V", "Ljava/lang/Boolean;", "Ljava/lang/Integer;", "Ljava/lang/Float;", "copy", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Lokio/ByteString;)Lcom/tencent/tavcut/composition/model/component/TextReplaceItem;", "equals", "other", "", "hashCode", "newBuilder", "toString", "Builder", "Companion", "lib_tavcut_model_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes26.dex */
public final class TextReplaceItem extends AndroidMessage<TextReplaceItem, Builder> {

    @JvmField
    @NotNull
    public static final ProtoAdapter<TextReplaceItem> ADAPTER;

    @JvmField
    @NotNull
    public static final Parcelable.Creator<TextReplaceItem> CREATOR;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 10)
    @JvmField
    @Nullable
    public final Boolean applyStroke;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 16)
    @JvmField
    @Nullable
    public final Integer backgroundAlpha;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 15)
    @JvmField
    @Nullable
    public final String backgroundColor;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 6)
    @JvmField
    @Nullable
    public final Boolean fauxBold;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 7)
    @JvmField
    @Nullable
    public final Boolean fauxItalic;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 8)
    @JvmField
    @Nullable
    public final String fontFamily;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 9)
    @JvmField
    @Nullable
    public final String fontPath;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 19)
    @JvmField
    @Nullable
    public final String fontStyle;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 18)
    @JvmField
    @Nullable
    public final Integer justification;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 13)
    @JvmField
    @Nullable
    public final Float leading;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 11)
    @JvmField
    @Nullable
    public final String strokeColor;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 20)
    @JvmField
    @Nullable
    public final Boolean strokeOverFill;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 12)
    @JvmField
    @Nullable
    public final Float strokeWidth;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 17)
    @JvmField
    @Nullable
    public final String textColor;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 14)
    @JvmField
    @Nullable
    public final Float tracking;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u000b\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0015\u0010\u0004\u001a\u00020\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u001aJ\u0015\u0010\u0007\u001a\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0002\u0010\u001bJ\u0010\u0010\n\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\b\u0010\u001c\u001a\u00020\u0002H\u0016J\u0015\u0010\f\u001a\u00020\u00002\b\u0010\f\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u001aJ\u0015\u0010\r\u001a\u00020\u00002\b\u0010\r\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u001aJ\u0010\u0010\u000e\u001a\u00020\u00002\b\u0010\u000e\u001a\u0004\u0018\u00010\u000bJ\u0010\u0010\u000f\u001a\u00020\u00002\b\u0010\u000f\u001a\u0004\u0018\u00010\u000bJ\u0010\u0010\u0010\u001a\u00020\u00002\b\u0010\u0010\u001a\u0004\u0018\u00010\u000bJ\u0015\u0010\u0011\u001a\u00020\u00002\b\u0010\u0011\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0002\u0010\u001bJ\u0015\u0010\u0012\u001a\u00020\u00002\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u00a2\u0006\u0002\u0010\u001dJ\u0010\u0010\u0015\u001a\u00020\u00002\b\u0010\u0015\u001a\u0004\u0018\u00010\u000bJ\u0015\u0010\u0016\u001a\u00020\u00002\b\u0010\u0016\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u001aJ\u0015\u0010\u0017\u001a\u00020\u00002\b\u0010\u0017\u001a\u0004\u0018\u00010\u0013\u00a2\u0006\u0002\u0010\u001dJ\u0010\u0010\u0018\u001a\u00020\u00002\b\u0010\u0018\u001a\u0004\u0018\u00010\u000bJ\u0015\u0010\u0019\u001a\u00020\u00002\b\u0010\u0019\u001a\u0004\u0018\u00010\u0013\u00a2\u0006\u0002\u0010\u001dR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\tR\u0014\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\r\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\tR\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0014R\u0014\u0010\u0015\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0016\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\u0017\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0014R\u0014\u0010\u0018\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0019\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0014\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/tavcut/composition/model/component/TextReplaceItem$Builder;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/tavcut/composition/model/component/TextReplaceItem;", "()V", "applyStroke", "", "Ljava/lang/Boolean;", "backgroundAlpha", "", "Ljava/lang/Integer;", "backgroundColor", "", "fauxBold", "fauxItalic", "fontFamily", "fontPath", "fontStyle", "justification", "leading", "", "Ljava/lang/Float;", "strokeColor", "strokeOverFill", "strokeWidth", "textColor", "tracking", "(Ljava/lang/Boolean;)Lcom/tencent/tavcut/composition/model/component/TextReplaceItem$Builder;", "(Ljava/lang/Integer;)Lcom/tencent/tavcut/composition/model/component/TextReplaceItem$Builder;", "build", "(Ljava/lang/Float;)Lcom/tencent/tavcut/composition/model/component/TextReplaceItem$Builder;", "lib_tavcut_model_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes26.dex */
    public static final class Builder extends Message.Builder<TextReplaceItem, Builder> {

        @JvmField
        @Nullable
        public Boolean applyStroke;

        @JvmField
        @Nullable
        public Integer backgroundAlpha;

        @JvmField
        @Nullable
        public String backgroundColor;

        @JvmField
        @Nullable
        public Boolean fauxBold;

        @JvmField
        @Nullable
        public Boolean fauxItalic;

        @JvmField
        @Nullable
        public String fontFamily;

        @JvmField
        @Nullable
        public String fontPath;

        @JvmField
        @Nullable
        public String fontStyle;

        @JvmField
        @Nullable
        public Integer justification;

        @JvmField
        @Nullable
        public Float leading;

        @JvmField
        @Nullable
        public String strokeColor;

        @JvmField
        @Nullable
        public Boolean strokeOverFill;

        @JvmField
        @Nullable
        public Float strokeWidth;

        @JvmField
        @Nullable
        public String textColor;

        @JvmField
        @Nullable
        public Float tracking;

        @NotNull
        public final Builder applyStroke(@Nullable Boolean applyStroke) {
            this.applyStroke = applyStroke;
            return this;
        }

        @NotNull
        public final Builder backgroundAlpha(@Nullable Integer backgroundAlpha) {
            this.backgroundAlpha = backgroundAlpha;
            return this;
        }

        @NotNull
        public final Builder backgroundColor(@Nullable String backgroundColor) {
            this.backgroundColor = backgroundColor;
            return this;
        }

        @NotNull
        public final Builder fauxBold(@Nullable Boolean fauxBold) {
            this.fauxBold = fauxBold;
            return this;
        }

        @NotNull
        public final Builder fauxItalic(@Nullable Boolean fauxItalic) {
            this.fauxItalic = fauxItalic;
            return this;
        }

        @NotNull
        public final Builder fontFamily(@Nullable String fontFamily) {
            this.fontFamily = fontFamily;
            return this;
        }

        @NotNull
        public final Builder fontPath(@Nullable String fontPath) {
            this.fontPath = fontPath;
            return this;
        }

        @NotNull
        public final Builder fontStyle(@Nullable String fontStyle) {
            this.fontStyle = fontStyle;
            return this;
        }

        @NotNull
        public final Builder justification(@Nullable Integer justification) {
            this.justification = justification;
            return this;
        }

        @NotNull
        public final Builder leading(@Nullable Float leading) {
            this.leading = leading;
            return this;
        }

        @NotNull
        public final Builder strokeColor(@Nullable String strokeColor) {
            this.strokeColor = strokeColor;
            return this;
        }

        @NotNull
        public final Builder strokeOverFill(@Nullable Boolean strokeOverFill) {
            this.strokeOverFill = strokeOverFill;
            return this;
        }

        @NotNull
        public final Builder strokeWidth(@Nullable Float strokeWidth) {
            this.strokeWidth = strokeWidth;
            return this;
        }

        @NotNull
        public final Builder textColor(@Nullable String textColor) {
            this.textColor = textColor;
            return this;
        }

        @NotNull
        public final Builder tracking(@Nullable Float tracking) {
            this.tracking = tracking;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        @NotNull
        public TextReplaceItem build() {
            return new TextReplaceItem(this.fauxBold, this.fauxItalic, this.fontFamily, this.fontPath, this.applyStroke, this.strokeColor, this.strokeWidth, this.leading, this.tracking, this.backgroundColor, this.backgroundAlpha, this.textColor, this.justification, this.fontStyle, this.strokeOverFill, buildUnknownFields());
        }
    }

    static {
        final FieldEncoding fieldEncoding = FieldEncoding.LENGTH_DELIMITED;
        final KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(TextReplaceItem.class);
        final String str = "type.googleapis.com/publisher.TextReplaceItem";
        ProtoAdapter<TextReplaceItem> protoAdapter = new ProtoAdapter<TextReplaceItem>(fieldEncoding, orCreateKotlinClass, str) { // from class: com.tencent.tavcut.composition.model.component.TextReplaceItem$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            public TextReplaceItem decode(@NotNull ProtoReader reader) {
                Intrinsics.checkParameterIsNotNull(reader, "reader");
                long beginMessage = reader.beginMessage();
                Boolean bool = null;
                Boolean bool2 = null;
                String str2 = null;
                String str3 = null;
                Boolean bool3 = null;
                String str4 = null;
                Float f16 = null;
                Float f17 = null;
                Float f18 = null;
                String str5 = null;
                Integer num = null;
                String str6 = null;
                Integer num2 = null;
                String str7 = null;
                Boolean bool4 = null;
                while (true) {
                    int nextTag = reader.nextTag();
                    if (nextTag == -1) {
                        return new TextReplaceItem(bool, bool2, str2, str3, bool3, str4, f16, f17, f18, str5, num, str6, num2, str7, bool4, reader.endMessageAndGetUnknownFields(beginMessage));
                    }
                    switch (nextTag) {
                        case 6:
                            bool = ProtoAdapter.BOOL.decode(reader);
                            break;
                        case 7:
                            bool2 = ProtoAdapter.BOOL.decode(reader);
                            break;
                        case 8:
                            str2 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 9:
                            str3 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 10:
                            bool3 = ProtoAdapter.BOOL.decode(reader);
                            break;
                        case 11:
                            str4 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 12:
                            f16 = ProtoAdapter.FLOAT.decode(reader);
                            break;
                        case 13:
                            f17 = ProtoAdapter.FLOAT.decode(reader);
                            break;
                        case 14:
                            f18 = ProtoAdapter.FLOAT.decode(reader);
                            break;
                        case 15:
                            str5 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 16:
                            num = ProtoAdapter.INT32.decode(reader);
                            break;
                        case 17:
                            str6 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 18:
                            num2 = ProtoAdapter.INT32.decode(reader);
                            break;
                        case 19:
                            str7 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 20:
                            bool4 = ProtoAdapter.BOOL.decode(reader);
                            break;
                        default:
                            reader.readUnknownField(nextTag);
                            break;
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(@NotNull ProtoWriter writer, @NotNull TextReplaceItem value) {
                Intrinsics.checkParameterIsNotNull(writer, "writer");
                Intrinsics.checkParameterIsNotNull(value, "value");
                ProtoAdapter<Boolean> protoAdapter2 = ProtoAdapter.BOOL;
                protoAdapter2.encodeWithTag(writer, 6, value.fauxBold);
                protoAdapter2.encodeWithTag(writer, 7, value.fauxItalic);
                ProtoAdapter<String> protoAdapter3 = ProtoAdapter.STRING;
                protoAdapter3.encodeWithTag(writer, 8, value.fontFamily);
                protoAdapter3.encodeWithTag(writer, 9, value.fontPath);
                protoAdapter2.encodeWithTag(writer, 10, value.applyStroke);
                protoAdapter3.encodeWithTag(writer, 11, value.strokeColor);
                ProtoAdapter<Float> protoAdapter4 = ProtoAdapter.FLOAT;
                protoAdapter4.encodeWithTag(writer, 12, value.strokeWidth);
                protoAdapter4.encodeWithTag(writer, 13, value.leading);
                protoAdapter4.encodeWithTag(writer, 14, value.tracking);
                protoAdapter3.encodeWithTag(writer, 15, value.backgroundColor);
                ProtoAdapter<Integer> protoAdapter5 = ProtoAdapter.INT32;
                protoAdapter5.encodeWithTag(writer, 16, value.backgroundAlpha);
                protoAdapter3.encodeWithTag(writer, 17, value.textColor);
                protoAdapter5.encodeWithTag(writer, 18, value.justification);
                protoAdapter3.encodeWithTag(writer, 19, value.fontStyle);
                protoAdapter2.encodeWithTag(writer, 20, value.strokeOverFill);
                writer.writeBytes(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(@NotNull TextReplaceItem value) {
                Intrinsics.checkParameterIsNotNull(value, "value");
                ProtoAdapter<Boolean> protoAdapter2 = ProtoAdapter.BOOL;
                int encodedSizeWithTag = protoAdapter2.encodedSizeWithTag(6, value.fauxBold) + protoAdapter2.encodedSizeWithTag(7, value.fauxItalic);
                ProtoAdapter<String> protoAdapter3 = ProtoAdapter.STRING;
                int encodedSizeWithTag2 = encodedSizeWithTag + protoAdapter3.encodedSizeWithTag(8, value.fontFamily) + protoAdapter3.encodedSizeWithTag(9, value.fontPath) + protoAdapter2.encodedSizeWithTag(10, value.applyStroke) + protoAdapter3.encodedSizeWithTag(11, value.strokeColor);
                ProtoAdapter<Float> protoAdapter4 = ProtoAdapter.FLOAT;
                int encodedSizeWithTag3 = encodedSizeWithTag2 + protoAdapter4.encodedSizeWithTag(12, value.strokeWidth) + protoAdapter4.encodedSizeWithTag(13, value.leading) + protoAdapter4.encodedSizeWithTag(14, value.tracking) + protoAdapter3.encodedSizeWithTag(15, value.backgroundColor);
                ProtoAdapter<Integer> protoAdapter5 = ProtoAdapter.INT32;
                return encodedSizeWithTag3 + protoAdapter5.encodedSizeWithTag(16, value.backgroundAlpha) + protoAdapter3.encodedSizeWithTag(17, value.textColor) + protoAdapter5.encodedSizeWithTag(18, value.justification) + protoAdapter3.encodedSizeWithTag(19, value.fontStyle) + protoAdapter2.encodedSizeWithTag(20, value.strokeOverFill) + value.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            public TextReplaceItem redact(@NotNull TextReplaceItem value) {
                TextReplaceItem copy;
                Intrinsics.checkParameterIsNotNull(value, "value");
                copy = value.copy((r34 & 1) != 0 ? value.fauxBold : null, (r34 & 2) != 0 ? value.fauxItalic : null, (r34 & 4) != 0 ? value.fontFamily : null, (r34 & 8) != 0 ? value.fontPath : null, (r34 & 16) != 0 ? value.applyStroke : null, (r34 & 32) != 0 ? value.strokeColor : null, (r34 & 64) != 0 ? value.strokeWidth : null, (r34 & 128) != 0 ? value.leading : null, (r34 & 256) != 0 ? value.tracking : null, (r34 & 512) != 0 ? value.backgroundColor : null, (r34 & 1024) != 0 ? value.backgroundAlpha : null, (r34 & 2048) != 0 ? value.textColor : null, (r34 & 4096) != 0 ? value.justification : null, (r34 & 8192) != 0 ? value.fontStyle : null, (r34 & 16384) != 0 ? value.strokeOverFill : null, (r34 & 32768) != 0 ? value.unknownFields() : ByteString.EMPTY);
                return copy;
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = AndroidMessage.INSTANCE.newCreator(protoAdapter);
    }

    public TextReplaceItem() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 65535, null);
    }

    @NotNull
    public final TextReplaceItem copy(@Nullable Boolean fauxBold, @Nullable Boolean fauxItalic, @Nullable String fontFamily, @Nullable String fontPath, @Nullable Boolean applyStroke, @Nullable String strokeColor, @Nullable Float strokeWidth, @Nullable Float leading, @Nullable Float tracking, @Nullable String backgroundColor, @Nullable Integer backgroundAlpha, @Nullable String textColor, @Nullable Integer justification, @Nullable String fontStyle, @Nullable Boolean strokeOverFill, @NotNull ByteString unknownFields) {
        Intrinsics.checkParameterIsNotNull(unknownFields, "unknownFields");
        return new TextReplaceItem(fauxBold, fauxItalic, fontFamily, fontPath, applyStroke, strokeColor, strokeWidth, leading, tracking, backgroundColor, backgroundAlpha, textColor, justification, fontStyle, strokeOverFill, unknownFields);
    }

    public boolean equals(@Nullable Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof TextReplaceItem)) {
            return false;
        }
        TextReplaceItem textReplaceItem = (TextReplaceItem) other;
        if (Intrinsics.areEqual(unknownFields(), textReplaceItem.unknownFields()) && Intrinsics.areEqual(this.fauxBold, textReplaceItem.fauxBold) && Intrinsics.areEqual(this.fauxItalic, textReplaceItem.fauxItalic) && Intrinsics.areEqual(this.fontFamily, textReplaceItem.fontFamily) && Intrinsics.areEqual(this.fontPath, textReplaceItem.fontPath) && Intrinsics.areEqual(this.applyStroke, textReplaceItem.applyStroke) && Intrinsics.areEqual(this.strokeColor, textReplaceItem.strokeColor) && Intrinsics.areEqual(this.strokeWidth, textReplaceItem.strokeWidth) && Intrinsics.areEqual(this.leading, textReplaceItem.leading) && Intrinsics.areEqual(this.tracking, textReplaceItem.tracking) && Intrinsics.areEqual(this.backgroundColor, textReplaceItem.backgroundColor) && Intrinsics.areEqual(this.backgroundAlpha, textReplaceItem.backgroundAlpha) && Intrinsics.areEqual(this.textColor, textReplaceItem.textColor) && Intrinsics.areEqual(this.justification, textReplaceItem.justification) && Intrinsics.areEqual(this.fontStyle, textReplaceItem.fontStyle) && Intrinsics.areEqual(this.strokeOverFill, textReplaceItem.strokeOverFill)) {
            return true;
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
        int i27;
        int i28;
        int i29;
        int i36;
        int i37;
        int i38;
        int i39;
        int i46;
        int i47 = this.hashCode;
        if (i47 == 0) {
            int hashCode = unknownFields().hashCode() * 37;
            Boolean bool = this.fauxBold;
            int i48 = 0;
            if (bool != null) {
                i3 = bool.hashCode();
            } else {
                i3 = 0;
            }
            int i49 = (hashCode + i3) * 37;
            Boolean bool2 = this.fauxItalic;
            if (bool2 != null) {
                i16 = bool2.hashCode();
            } else {
                i16 = 0;
            }
            int i56 = (i49 + i16) * 37;
            String str = this.fontFamily;
            if (str != null) {
                i17 = str.hashCode();
            } else {
                i17 = 0;
            }
            int i57 = (i56 + i17) * 37;
            String str2 = this.fontPath;
            if (str2 != null) {
                i18 = str2.hashCode();
            } else {
                i18 = 0;
            }
            int i58 = (i57 + i18) * 37;
            Boolean bool3 = this.applyStroke;
            if (bool3 != null) {
                i19 = bool3.hashCode();
            } else {
                i19 = 0;
            }
            int i59 = (i58 + i19) * 37;
            String str3 = this.strokeColor;
            if (str3 != null) {
                i26 = str3.hashCode();
            } else {
                i26 = 0;
            }
            int i65 = (i59 + i26) * 37;
            Float f16 = this.strokeWidth;
            if (f16 != null) {
                i27 = f16.hashCode();
            } else {
                i27 = 0;
            }
            int i66 = (i65 + i27) * 37;
            Float f17 = this.leading;
            if (f17 != null) {
                i28 = f17.hashCode();
            } else {
                i28 = 0;
            }
            int i67 = (i66 + i28) * 37;
            Float f18 = this.tracking;
            if (f18 != null) {
                i29 = f18.hashCode();
            } else {
                i29 = 0;
            }
            int i68 = (i67 + i29) * 37;
            String str4 = this.backgroundColor;
            if (str4 != null) {
                i36 = str4.hashCode();
            } else {
                i36 = 0;
            }
            int i69 = (i68 + i36) * 37;
            Integer num = this.backgroundAlpha;
            if (num != null) {
                i37 = num.hashCode();
            } else {
                i37 = 0;
            }
            int i75 = (i69 + i37) * 37;
            String str5 = this.textColor;
            if (str5 != null) {
                i38 = str5.hashCode();
            } else {
                i38 = 0;
            }
            int i76 = (i75 + i38) * 37;
            Integer num2 = this.justification;
            if (num2 != null) {
                i39 = num2.hashCode();
            } else {
                i39 = 0;
            }
            int i77 = (i76 + i39) * 37;
            String str6 = this.fontStyle;
            if (str6 != null) {
                i46 = str6.hashCode();
            } else {
                i46 = 0;
            }
            int i78 = (i77 + i46) * 37;
            Boolean bool4 = this.strokeOverFill;
            if (bool4 != null) {
                i48 = bool4.hashCode();
            }
            int i79 = i78 + i48;
            this.hashCode = i79;
            return i79;
        }
        return i47;
    }

    @Override // com.squareup.wire.Message
    @NotNull
    public String toString() {
        String joinToString$default;
        ArrayList arrayList = new ArrayList();
        if (this.fauxBold != null) {
            arrayList.add("fauxBold=" + this.fauxBold);
        }
        if (this.fauxItalic != null) {
            arrayList.add("fauxItalic=" + this.fauxItalic);
        }
        if (this.fontFamily != null) {
            arrayList.add("fontFamily=" + Internal.sanitize(this.fontFamily));
        }
        if (this.fontPath != null) {
            arrayList.add("fontPath=" + Internal.sanitize(this.fontPath));
        }
        if (this.applyStroke != null) {
            arrayList.add("applyStroke=" + this.applyStroke);
        }
        if (this.strokeColor != null) {
            arrayList.add("strokeColor=" + Internal.sanitize(this.strokeColor));
        }
        if (this.strokeWidth != null) {
            arrayList.add("strokeWidth=" + this.strokeWidth);
        }
        if (this.leading != null) {
            arrayList.add("leading=" + this.leading);
        }
        if (this.tracking != null) {
            arrayList.add("tracking=" + this.tracking);
        }
        if (this.backgroundColor != null) {
            arrayList.add("backgroundColor=" + Internal.sanitize(this.backgroundColor));
        }
        if (this.backgroundAlpha != null) {
            arrayList.add("backgroundAlpha=" + this.backgroundAlpha);
        }
        if (this.textColor != null) {
            arrayList.add("textColor=" + Internal.sanitize(this.textColor));
        }
        if (this.justification != null) {
            arrayList.add("justification=" + this.justification);
        }
        if (this.fontStyle != null) {
            arrayList.add("fontStyle=" + Internal.sanitize(this.fontStyle));
        }
        if (this.strokeOverFill != null) {
            arrayList.add("strokeOverFill=" + this.strokeOverFill);
        }
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, ", ", "TextReplaceItem{", "}", 0, null, null, 56, null);
        return joinToString$default;
    }

    public /* synthetic */ TextReplaceItem(Boolean bool, Boolean bool2, String str, String str2, Boolean bool3, String str3, Float f16, Float f17, Float f18, String str4, Integer num, String str5, Integer num2, String str6, Boolean bool4, ByteString byteString, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : bool, (i3 & 2) != 0 ? null : bool2, (i3 & 4) != 0 ? null : str, (i3 & 8) != 0 ? null : str2, (i3 & 16) != 0 ? null : bool3, (i3 & 32) != 0 ? null : str3, (i3 & 64) != 0 ? null : f16, (i3 & 128) != 0 ? null : f17, (i3 & 256) != 0 ? null : f18, (i3 & 512) != 0 ? null : str4, (i3 & 1024) != 0 ? null : num, (i3 & 2048) != 0 ? null : str5, (i3 & 4096) != 0 ? null : num2, (i3 & 8192) != 0 ? null : str6, (i3 & 16384) != 0 ? null : bool4, (i3 & 32768) != 0 ? ByteString.EMPTY : byteString);
    }

    @Override // com.squareup.wire.Message
    @NotNull
    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.fauxBold = this.fauxBold;
        builder.fauxItalic = this.fauxItalic;
        builder.fontFamily = this.fontFamily;
        builder.fontPath = this.fontPath;
        builder.applyStroke = this.applyStroke;
        builder.strokeColor = this.strokeColor;
        builder.strokeWidth = this.strokeWidth;
        builder.leading = this.leading;
        builder.tracking = this.tracking;
        builder.backgroundColor = this.backgroundColor;
        builder.backgroundAlpha = this.backgroundAlpha;
        builder.textColor = this.textColor;
        builder.justification = this.justification;
        builder.fontStyle = this.fontStyle;
        builder.strokeOverFill = this.strokeOverFill;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextReplaceItem(@Nullable Boolean bool, @Nullable Boolean bool2, @Nullable String str, @Nullable String str2, @Nullable Boolean bool3, @Nullable String str3, @Nullable Float f16, @Nullable Float f17, @Nullable Float f18, @Nullable String str4, @Nullable Integer num, @Nullable String str5, @Nullable Integer num2, @Nullable String str6, @Nullable Boolean bool4, @NotNull ByteString unknownFields) {
        super(ADAPTER, unknownFields);
        Intrinsics.checkParameterIsNotNull(unknownFields, "unknownFields");
        this.fauxBold = bool;
        this.fauxItalic = bool2;
        this.fontFamily = str;
        this.fontPath = str2;
        this.applyStroke = bool3;
        this.strokeColor = str3;
        this.strokeWidth = f16;
        this.leading = f17;
        this.tracking = f18;
        this.backgroundColor = str4;
        this.backgroundAlpha = num;
        this.textColor = str5;
        this.justification = num2;
        this.fontStyle = str6;
        this.strokeOverFill = bool4;
    }
}
