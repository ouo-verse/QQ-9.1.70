package com.tencent.mobileqq.guild.temp.api.impl;

import android.text.Editable;
import com.tencent.mobileqq.guild.temp.api.IEmoEditableFactoryApi;
import com.tencent.mobileqq.text.QQTextBuilder;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/guild/temp/api/impl/EmoEditableFactoryApiImpl;", "Lcom/tencent/mobileqq/guild/temp/api/IEmoEditableFactoryApi;", "()V", "getEmoEditableFactory", "Landroid/text/Editable$Factory;", "emoSize", "", "grabFlags", "qqguild_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class EmoEditableFactoryApiImpl implements IEmoEditableFactoryApi {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/temp/api/impl/EmoEditableFactoryApiImpl$a", "Landroid/text/Editable$Factory;", "", "source", "Landroid/text/Editable;", "newEditable", "qqguild_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class a extends Editable.Factory {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f235243a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f235244b;

        a(int i3, int i16) {
            this.f235243a = i3;
            this.f235244b = i16;
        }

        @Override // android.text.Editable.Factory
        public Editable newEditable(CharSequence source) {
            QQTextBuilder qQTextBuilder = source instanceof QQTextBuilder ? (QQTextBuilder) source : null;
            return qQTextBuilder != null ? qQTextBuilder : new QQTextBuilder(source, this.f235243a, this.f235244b);
        }
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IEmoEditableFactoryApi
    public Editable.Factory getEmoEditableFactory(int emoSize, int grabFlags) {
        return new a(grabFlags, emoSize);
    }
}
