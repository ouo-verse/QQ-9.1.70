package com.tencent.qqnt.aio.adapter.api.impl;

import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.qqnt.aio.adapter.api.IMsgConverterUtilsApi;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0012\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0012\u0010\f\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0012\u0010\r\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u001a\u0010\u000f\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0007\u001a\u00020\bH\u0016\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/MsgConverterUtilsApiImpl;", "Lcom/tencent/qqnt/aio/adapter/api/IMsgConverterUtilsApi;", "()V", "convertToChatMessage", "Lcom/tencent/mobileqq/data/ChatMessage;", "app", "Lmqq/app/AppRuntime;", "msgRecord", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "getArkMsgElem", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "getFaceMsgElem", "getFileMsgElem", "getMKDMsgElem", "getMarketFaceMsgElem", "getMsgElem", "elementId", "", "getMultiForwardMsgElem", "getPicMsgElem", "getPttMsgElem", "getVideoMsgElem", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes34.dex */
public final class MsgConverterUtilsApiImpl implements IMsgConverterUtilsApi {
    @Override // com.tencent.qqnt.aio.adapter.api.IMsgConverterUtilsApi
    public ChatMessage convertToChatMessage(AppRuntime app, MsgRecord msgRecord) {
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        return qu3.i.a(app, msgRecord);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IMsgConverterUtilsApi
    public MsgElement getArkMsgElem(MsgRecord msgRecord) {
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        return qu3.i.f429570a.b(msgRecord);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IMsgConverterUtilsApi
    public MsgElement getFaceMsgElem(MsgRecord msgRecord) {
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        return qu3.i.f429570a.d(msgRecord);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IMsgConverterUtilsApi
    public MsgElement getFileMsgElem(MsgRecord msgRecord) {
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        return qu3.i.e(msgRecord);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IMsgConverterUtilsApi
    public MsgElement getMKDMsgElem(MsgRecord msgRecord) {
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        return qu3.i.f429570a.f(msgRecord);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IMsgConverterUtilsApi
    public MsgElement getMarketFaceMsgElem(MsgRecord msgRecord) {
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        return qu3.i.f429570a.h(msgRecord);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IMsgConverterUtilsApi
    public MsgElement getMsgElem(MsgRecord msgRecord, long elementId) {
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        return qu3.i.f429570a.i(msgRecord, elementId);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IMsgConverterUtilsApi
    public MsgElement getMultiForwardMsgElem(MsgRecord msgRecord) {
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        return qu3.i.f429570a.j(msgRecord);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IMsgConverterUtilsApi
    public MsgElement getPicMsgElem(MsgRecord msgRecord) {
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        return qu3.i.f429570a.k(msgRecord);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IMsgConverterUtilsApi
    public MsgElement getPttMsgElem(MsgRecord msgRecord) {
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        return qu3.i.f429570a.l(msgRecord);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IMsgConverterUtilsApi
    public MsgElement getVideoMsgElem(MsgRecord msgRecord) {
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        return qu3.i.f429570a.m(msgRecord);
    }
}
