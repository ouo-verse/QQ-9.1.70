package com.tencent.ecommerce.biz.orders.address;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ecommerce.biz.orders.address.ECAddressListAdapter;
import com.tencent.ecommerce.repo.ServiceLocator;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b*\u0010+J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0016\u0010\u0007\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0006\u0010\b\u001a\u00020\u0005J\u000e\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\f\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\r\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tR\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\"\u0010\u0015\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R'\u0010\u001c\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00170\u00168\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\"\u0010$\u001a\u00020\u001d8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001c\u0010&\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010\u0014R\u001f\u0010)\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00168\u0006\u00a2\u0006\f\n\u0004\b'\u0010\u0019\u001a\u0004\b(\u0010\u001b\u00a8\u0006,"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/address/ECAddressManagerViewModel;", "Landroidx/lifecycle/ViewModel;", "", "Lcom/tencent/ecommerce/biz/orders/address/ECAddressListAdapter$a;", "list", "", "U1", "W1", "P1", "Lcom/tencent/ecommerce/biz/orders/address/ECAddress;", "address", "O1", "T1", "Z1", "Lcom/tencent/ecommerce/biz/orders/address/IECAddressRepository;", "i", "Lcom/tencent/ecommerce/biz/orders/address/IECAddressRepository;", "repo", "Landroidx/lifecycle/MutableLiveData;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/MutableLiveData;", "_allECAddress", "Landroidx/lifecycle/LiveData;", "", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/lifecycle/LiveData;", "Q1", "()Landroidx/lifecycle/LiveData;", "allECAddress", "", "D", "J", "R1", "()J", "X1", "(J)V", "initSelectedAddressId", "E", "_selectedAddress", UserInfo.SEX_FEMALE, "S1", "selectedAddress", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECAddressManagerViewModel extends ViewModel {

    /* renamed from: C, reason: from kotlin metadata */
    private final LiveData<? extends List<ECAddressListAdapter.ECAddressItemData>> allECAddress;

    /* renamed from: D, reason: from kotlin metadata */
    private long initSelectedAddressId;

    /* renamed from: E, reason: from kotlin metadata */
    private final MutableLiveData<ECAddress> _selectedAddress;

    /* renamed from: F, reason: from kotlin metadata */
    private final LiveData<ECAddress> selectedAddress;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final IECAddressRepository repo = ServiceLocator.f104891i.b();

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<List<ECAddressListAdapter.ECAddressItemData>> _allECAddress;

    public ECAddressManagerViewModel() {
        MutableLiveData<List<ECAddressListAdapter.ECAddressItemData>> mutableLiveData = new MutableLiveData<>();
        this._allECAddress = mutableLiveData;
        this.allECAddress = mutableLiveData;
        this.initSelectedAddressId = -1L;
        MutableLiveData<ECAddress> mutableLiveData2 = new MutableLiveData<>();
        this._selectedAddress = mutableLiveData2;
        this.selectedAddress = mutableLiveData2;
    }

    private final void W1(List<ECAddressListAdapter.ECAddressItemData> list) {
        Iterator<ECAddressListAdapter.ECAddressItemData> it = list.iterator();
        int i3 = 0;
        while (true) {
            if (!it.hasNext()) {
                i3 = -1;
                break;
            } else if (it.next().getIsSelected()) {
                break;
            } else {
                i3++;
            }
        }
        if (i3 != -1) {
            list.set(i3, ECAddressListAdapter.ECAddressItemData.b(list.get(i3), null, false, 1, null));
        }
    }

    public final void O1(ECAddress address) {
        List<ECAddressListAdapter.ECAddressItemData> value = this._allECAddress.getValue();
        if (value == null) {
            value = new ArrayList<>();
        }
        W1(value);
        if (address.isDefaultAddress) {
            U1(value);
        }
        if ((!value.isEmpty()) && value.get(0).getAddress().isDefaultAddress) {
            value.add(1, new ECAddressListAdapter.ECAddressItemData(address, true));
        } else {
            value.add(0, new ECAddressListAdapter.ECAddressItemData(address, true));
        }
        this._allECAddress.setValue(value);
        this._selectedAddress.setValue(address);
    }

    public final void P1() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new ECAddressManagerViewModel$fetchAddress$1(this, null), 3, null);
    }

    public final LiveData<? extends List<ECAddressListAdapter.ECAddressItemData>> Q1() {
        return this.allECAddress;
    }

    /* renamed from: R1, reason: from getter */
    public final long getInitSelectedAddressId() {
        return this.initSelectedAddressId;
    }

    public final LiveData<ECAddress> S1() {
        return this.selectedAddress;
    }

    public final void T1(ECAddress address) {
        Object obj;
        List<ECAddressListAdapter.ECAddressItemData> value = this._allECAddress.getValue();
        if (value == null) {
            value = new ArrayList<>();
        }
        for (Object obj2 : value) {
            if (address.id == ((ECAddressListAdapter.ECAddressItemData) obj2).getAddress().id) {
                value.remove(obj2);
                Iterator<T> it = value.iterator();
                while (true) {
                    if (it.hasNext()) {
                        obj = it.next();
                        if (((ECAddressListAdapter.ECAddressItemData) obj).getIsSelected()) {
                            break;
                        }
                    } else {
                        obj = null;
                        break;
                    }
                }
                if (((ECAddressListAdapter.ECAddressItemData) obj) == null) {
                    if (!value.isEmpty()) {
                        value.set(0, ECAddressListAdapter.ECAddressItemData.b(value.get(0), null, true, 1, null));
                        this._selectedAddress.setValue(value.get(0).getAddress());
                    } else {
                        this._selectedAddress.setValue(null);
                    }
                }
                this._allECAddress.setValue(value);
                return;
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    public final void X1(long j3) {
        this.initSelectedAddressId = j3;
    }

    public final void Z1(ECAddress address) {
        List<ECAddressListAdapter.ECAddressItemData> value = this._allECAddress.getValue();
        if (value == null) {
            value = new ArrayList<>();
        }
        W1(value);
        Iterator<ECAddressListAdapter.ECAddressItemData> it = value.iterator();
        int i3 = 0;
        while (true) {
            if (!it.hasNext()) {
                i3 = -1;
                break;
            } else {
                if (it.next().getAddress().id == address.id) {
                    break;
                } else {
                    i3++;
                }
            }
        }
        if (address.isDefaultAddress) {
            U1(value);
            value.remove(i3);
            value.add(0, new ECAddressListAdapter.ECAddressItemData(address, true));
        } else {
            value.set(i3, new ECAddressListAdapter.ECAddressItemData(address, true));
        }
        this._allECAddress.setValue(value);
        this._selectedAddress.setValue(address);
    }

    private final void U1(List<ECAddressListAdapter.ECAddressItemData> list) {
        ECAddress a16;
        Iterator<ECAddressListAdapter.ECAddressItemData> it = list.iterator();
        int i3 = 0;
        while (true) {
            if (!it.hasNext()) {
                i3 = -1;
                break;
            } else if (it.next().getAddress().isDefaultAddress) {
                break;
            } else {
                i3++;
            }
        }
        if (i3 >= 0) {
            ECAddress address = list.get(i3).getAddress();
            ECAddressListAdapter.ECAddressItemData eCAddressItemData = list.get(i3);
            a16 = address.a((r26 & 1) != 0 ? address.id : 0L, (r26 & 2) != 0 ? address.province : null, (r26 & 4) != 0 ? address.city : null, (r26 & 8) != 0 ? address.district : null, (r26 & 16) != 0 ? address.street : null, (r26 & 32) != 0 ? address.detailAddress : null, (r26 & 64) != 0 ? address.consignee : null, (r26 & 128) != 0 ? address.phoneNumber : null, (r26 & 256) != 0 ? address.maskedPhoneNumber : null, (r26 & 512) != 0 ? address.isDefaultAddress : false, (r26 & 1024) != 0 ? address.label : null);
            list.set(i3, ECAddressListAdapter.ECAddressItemData.b(eCAddressItemData, a16, false, 2, null));
        }
    }
}
